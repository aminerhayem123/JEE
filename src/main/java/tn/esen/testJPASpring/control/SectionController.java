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
public class SectionController {
	@Autowired
	private SectionRep repe;

	@RequestMapping(value="/sectionform" ,method=RequestMethod.GET)
	public String fromSection(Model model) {
		model.addAttribute("section",new Section());
		List <Section> section= repe.findAll();
		model.addAttribute("sections",section);
		return "FormSection";
	}
	
	@RequestMapping(value="/saveSection" ,method=RequestMethod.POST)
	public String save(@Valid Section s){
		repe.save(s);
		return "redirect:/etudiant/Index";
	}
	
}
