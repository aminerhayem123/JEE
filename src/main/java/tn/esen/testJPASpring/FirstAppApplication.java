package tn.esen.testJPASpring;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import tn.esen.testJPASpring.Repositories.EtudiantRep;

@SpringBootApplication
public class FirstAppApplication {

	public static void main(String[] args) throws ParseException {
		ApplicationContext ctx = SpringApplication.run(FirstAppApplication.class, args);
		EtudiantRep etudRep = ctx.getBean(EtudiantRep.class);
		/*
		DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
		etudRep.save(new Etudiant ("Ahmed" , df.parse("1999-01-11") ,"ahmed@gmail.com","ahmed.jpg"));
		etudRep.save(new Etudiant ("Mohamed" , df.parse("1997-05-31") ,"Mohamed@gmail.com","Mohamed.jpg"));
        Page<Etudiant> etds = etudRep.cherEtud("%o%",PageRequest.of(0,5));
        etds.forEach(e->System.out.println(e.getNom()));
        */
	}

}
