package tn.esen.testJPASpring.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tn.esen.testJPASpring.Repositories.EtudiantRep;
import tn.esen.testJPASpring.Repositories.SectionRep;
import tn.esen.testJPASpring.model.Etudiant;
import tn.esen.testJPASpring.model.Section;

@Controller
@RequestMapping(value="/etudiant")
public class EtudiantController {
	@Autowired
	private SectionRep repe;
	@Autowired
	private EtudiantRep rep;
	@RequestMapping(value="/Index")
	public String Index(Model model,@RequestParam(name="page",defaultValue="0")int p,@RequestParam(name="motCle",defaultValue="")String mc)
	{
		Page<Etudiant> etds = rep.cherEtud("%"+mc+"%",PageRequest.of(p, 5));
        int pagecount = etds.getTotalPages();
        int[] pages = new int[pagecount];
        for(int i=0;i<pagecount;i++)
        	pages[i]=i;
        model.addAttribute("pages",pages);
		model.addAttribute("etd",etds);
		model.addAttribute("pagecount",p);
		model.addAttribute("motCle",mc);
		return "Etudiant";
	}
	@RequestMapping(value="/form" ,method=RequestMethod.GET)
	public String fromEtudiant(Model model) {
		model.addAttribute("etudiant",new Etudiant());
		List <Section> section= repe.findAll();
		model.addAttribute("sections",section);
		return "FormEtudiant";
	}
	
	@RequestMapping(value="/saveEtudiant" ,method=RequestMethod.POST)
	public String save(@Valid Etudiant et,BindingResult bd,@RequestParam(name="picture") MultipartFile file) throws Exception, Exception {
		if (bd.hasErrors()) {
			return "FormEtudiant"; 
		}
		if(!(file.isEmpty())) {et.setPhoto(file.getOriginalFilename());}
		rep.save(et);
		if(!(file.isEmpty())) {
			et.setPhoto(file.getOriginalFilename());
			file.transferTo(new File(System.getProperty("user.home")+"/img/"+et.getId()));
		}
		return "redirect:/etudiant/Index";
	}
	
	@RequestMapping(value="/getphoto",produces = org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte [] getphoto(Long id ) throws Exception, Exception 
	{
     File f = new File(System.getProperty("user.home")+"/img/"+id);
     return org.apache.commons.io.IOUtils.toByteArray(new FileInputStream(f));
	}
	@RequestMapping(value="/supp")
	public String supp(Long id ) 
	{
     rep.deleteById(id);
     return "redirect:/etudiant/Index";
	}
	@RequestMapping(value="/edit")
	public String edit(Long id,Model model) 
	
	{
     Etudiant et = rep.getById(id);
     model.addAttribute("etudiant",et);
     List <Section> section= repe.findAll();
	 model.addAttribute("sections",section);
     return "Editetudiant";
	}
	@RequestMapping(value="/UpdateEtudiant" ,method=RequestMethod.POST)
	public String update(@Valid Etudiant et,BindingResult bd,@RequestParam(name="picture") MultipartFile file) throws Exception, Exception {
		if (bd.hasErrors()) {
			return "Editetudiant"; 
		}
		if(!(file.isEmpty())) {et.setPhoto(file.getOriginalFilename());}
		rep.save(et);
		if(!(file.isEmpty())) {
			et.setPhoto(file.getOriginalFilename());
			file.transferTo(new File(System.getProperty("user.home")+"/img/"+et.getId()));
		}
		return "redirect:/etudiant/Index";
	}
}
