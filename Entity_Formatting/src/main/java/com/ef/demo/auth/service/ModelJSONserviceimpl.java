package com.ef.demo.auth.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ef.demo.auth.repository.ModelJSONRepo;
import com.ef.demo.model.ModelJSON;


@Service
public class ModelJSONserviceimpl implements ModelJSONservice{
	@Autowired
	ModelJSONRepo repo;

	@Override
	public boolean findAll() {
		// TODO Auto-generated method stub
		List<ModelJSON> list;
		list = repo.findAll();
		if(list.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		repo.deleteAll();
	}

	@Override
	public void save(List<ModelJSON> list) {
		// TODO Auto-generated method stub
		repo.saveAll(list);
		
	}

//	@Override
//	public List<ModelJSON> formatting(String columnName, String currFormatt, String typeFormatt) {
//		// TODO Auto-generated method stub
//		if(columnName == "date") {
//			switch(typeFormatt) {
//			case "yyyy-mm-dd":
//				List<Object> list= repo.finddate();
//				if(currFormatt == "dd-mm-yyyy") {
//				 SimpleDateFormat inSDF = new SimpleDateFormat("dd-mm-yyyy");
//				 SimpleDateFormat outSDF = new SimpleDateFormat("yyyy-dd-mm");
//
//				 for(Object lists:list) {
//					    String outDate="";
//					    String inDate=(String) lists;
//			            Date date;
//						try {
//							date = inSDF.parse(inDate);
//				            outDate = outSDF.format(date);
//				            repo.updatedate(inDate, outDate);
//						} catch (ParseException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//				 }
//				}else if(currFormatt == "mm-dd-yyyy"){
//					SimpleDateFormat inSDF = new SimpleDateFormat("mm-dd-yyyy");
//					 SimpleDateFormat outSDF = new SimpleDateFormat("yyyy-dd-mm");
//
//					 for(Object lists:list) {
//						    String outDate="";
//						    String inDate=(String) lists;
//				            Date date;
//							try {
//								date = inSDF.parse(inDate);
//					            outDate = outSDF.format(date);
//					            repo.updatedate(inDate, outDate);
//							} catch (ParseException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//					 }
//				}else if(currFormatt == "mm-yyyy-dd") {
//					SimpleDateFormat inSDF = new SimpleDateFormat("mm-yyyy-dd");
//					 SimpleDateFormat outSDF = new SimpleDateFormat("yyyy-dd-mm");
//
//					 for(Object lists:list) {
//						    String outDate="";
//						    String inDate=(String) lists;
//				            Date date;
//							try {
//								date = inSDF.parse(inDate);
//					            outDate = outSDF.format(date);
//					            repo.updatedate(inDate, outDate);
//							} catch (ParseException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//					 }
//				}
//				 break;
//			case "mm-yyyy-dd":
//				List<Object> list1= repo.finddate();
//				if(currFormatt == "dd-mm-yyyy") {
//				 SimpleDateFormat inSDF = new SimpleDateFormat("dd-mm-yyyy");
//				 SimpleDateFormat outSDF = new SimpleDateFormat("mm-yyyy-dd");
//
//				 for(Object lists:list1) {
//					    String outDate="";
//					    String inDate=(String) lists;
//			            Date date;
//						try {
//							date = inSDF.parse(inDate);
//				            outDate = outSDF.format(date);
//				            repo.updatedate(inDate, outDate);
//						} catch (ParseException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//				 }
//				}else if(currFormatt == "yyyy-mm-dd"){
//					SimpleDateFormat inSDF = new SimpleDateFormat("yyyy-mm-dd");
//					 SimpleDateFormat outSDF = new SimpleDateFormat("mm-yyyy-dd");
//
//					 for(Object lists:list1) {
//						    String outDate="";
//						    String inDate=(String) lists;
//				            Date date;
//							try {
//								date = inSDF.parse(inDate);
//					            outDate = outSDF.format(date);
//					            repo.updatedate(inDate, outDate);
//							} catch (ParseException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//					 }
//				}else if(currFormatt == "mm-dd-yyyy") {
//					SimpleDateFormat inSDF = new SimpleDateFormat("mm-dd-yyyy");
//					 SimpleDateFormat outSDF = new SimpleDateFormat("mm-yyyy-dd");
//
//					 for(Object lists:list1) {
//						    String outDate="";
//						    String inDate=(String) lists;
//				            Date date;
//							try {
//								date = inSDF.parse(inDate);
//					            outDate = outSDF.format(date);
//					            repo.updatedate(inDate, outDate);
//							} catch (ParseException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//					 }
//				}
//				 break;
//			case "mm-dd-yyyy":
//				List<Object> list11= repo.finddate();
//				if(currFormatt == "dd-mm-yyyy") {
//				 SimpleDateFormat inSDF = new SimpleDateFormat("dd-mm-yyyy");
//				 SimpleDateFormat outSDF = new SimpleDateFormat("mm-dd-yyyy");
//
//				 for(Object lists:list11) {
//					    String outDate="";
//					    String inDate=(String) lists;
//			            Date date;
//						try {
//							date = inSDF.parse(inDate);
//				            outDate = outSDF.format(date);
//				            repo.updatedate(inDate, outDate);
//
//						} catch (ParseException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//				 }
//				}else if(currFormatt == "yyyy-mm-dd"){
//					SimpleDateFormat inSDF = new SimpleDateFormat("yyyy-mm-dd");
//					 SimpleDateFormat outSDF = new SimpleDateFormat("mm-dd-yyyy");
//
//					 for(Object lists:list11) {
//						    String outDate="";
//						    String inDate=(String) lists;
//				            Date date;
//							try {
//								date = inSDF.parse(inDate);
//					            outDate = outSDF.format(date);
//					            repo.updatedate(inDate, outDate);
//
//							} catch (ParseException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//					 }
//				}else if(currFormatt == "mm-yyyy-dd") {
//					SimpleDateFormat inSDF = new SimpleDateFormat("mm-yyyy-dd");
//					 SimpleDateFormat outSDF = new SimpleDateFormat("mm-dd-yyyy");
//
//					 for(Object lists:list11) {
//						    String outDate="";
//						    String inDate=(String) lists;
//				            Date date;
//							try {
//								date = inSDF.parse(inDate);
//					            outDate = outSDF.format(date);
//					            repo.updatedate(inDate, outDate);
//							} catch (ParseException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//				}
//				}
//				 break;
//			case "dd-mm-yyyy":
//				List<Object> list111= repo.finddate();
//				if(currFormatt == "mm-yyyy-dd") {
//				 SimpleDateFormat inSDF = new SimpleDateFormat("mm-yyyy-dd");
//				 SimpleDateFormat outSDF = new SimpleDateFormat("dd-mm-yyyy");
//
//				 for(Object lists:list111) {
//					    String outDate="";
//					    String inDate=(String) lists;
//			            Date date;
//						try {
//							date = inSDF.parse(inDate);
//				            outDate = outSDF.format(date);
//				            repo.updatedate(inDate, outDate);
//						} catch (ParseException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//				 }
//				}else if(currFormatt == "yyyy-mm-dd"){
//					SimpleDateFormat inSDF = new SimpleDateFormat("yyyy-mm-dd");
//					 SimpleDateFormat outSDF = new SimpleDateFormat("dd-mm-yyyy");
//
//					 for(Object lists:list111) {
//						    String outDate="";
//						    String inDate=(String) lists;
//				            Date date;
//							try {
//								date = inSDF.parse(inDate);
//					            outDate = outSDF.format(date);
//					            repo.updatedate(inDate, outDate);
//							} catch (ParseException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//					 }
//				}else if(currFormatt == "mm-dd-yyyy") {
//					SimpleDateFormat inSDF = new SimpleDateFormat("mm-dd-yyyy");
//					 SimpleDateFormat outSDF = new SimpleDateFormat("dd-mm-yyyy");
//
//					 for(Object lists:list111) {
//						    String outDate="";
//						    String inDate=(String) lists;
//				            Date date;
//							try {
//								date = inSDF.parse(inDate);
//					            outDate = outSDF.format(date);
//					            repo.updatedate(inDate, outDate);
//							} catch (ParseException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//					 }
//				}
//				 break;
//			}
//		}else {
//			System.out.println("leave it");
//		}
//		return repo.findAll();
//		
//	}
}
