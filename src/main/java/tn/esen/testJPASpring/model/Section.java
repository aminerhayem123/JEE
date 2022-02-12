package tn.esen.testJPASpring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SectionSpringDSSD")
public class Section {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ref;
	
	@Column(unique = true)
	private String label;
	
	

	public Long getRef() {
		return ref;
	}



	public void setRef(Long ref) {
		this.ref = ref;
	}



	public String getLabel() {
		return label;
	}



	public void setLabel(String label) {
		this.label = label;
	}


	

	@Override
	public String toString() {
		return "Section [ref=" + ref + ", label=" + label + "]";
	}



	public Section(String label) {
		super();
		this.label = label;
	}



	public Section() {
		// TODO Auto-generated constructor stub
	}

}