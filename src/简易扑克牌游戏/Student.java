package ¼òÒ×ÆË¿ËÅÆÓÎÏ·;

import java.util.ArrayList;
import java.util.List;

public class Student  {
	int id;
	String name;
	List<pukepai> shoupai=new ArrayList<pukepai>();
	pukepai maxpai;
	public Student(int id,String name){
		this.id=id;
		this.name=name;
		this.shoupai=new ArrayList<pukepai>();
		this.maxpai=new pukepai();
	}
	
}
