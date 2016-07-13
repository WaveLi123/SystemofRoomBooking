package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AdressData {
	private  static AdressData adressData;
	private List<String> provinceList;
	private List<List<String>> cityList;
	private List<List<String>> countryList;
	private List<String> allCityList ;
	private static String pathPrivince="/dat/province.txt";
	private static String pathCity="/dat/city.txt";
	private static String pathCountry="/dat/country.txt";
	public AdressData(){
		provinceList=new ArrayList<String>();
		cityList=new ArrayList<List<String>>();
		countryList =new ArrayList<List<String>>();
		lodingDataFromFile();
		allCityList =getCityList();

		
	}

	public static AdressData instance(){
		if(adressData==null)
			adressData=new AdressData();
		return adressData;
	}
	
	
public static AdressData getAdressData() {
		return adressData;
	}

	public static void setAdressData(AdressData adressData) {
		AdressData.adressData = adressData;
	}

	//获取省份的数据；
	public Object[] getPrivinceData(){
		
		return provinceList.toArray();
	}
//获取市的数据；
	public Object[] getCityDataById(int id){
		return cityList.get(id).toArray();
	}
	
	public List<String> getCityList(){
		List<String> tempList =new ArrayList<String>();
		for(int i=0;i<cityList.size();i++){
			tempList.addAll(cityList.get(i));
		}
		return tempList;
	}
//获取县 的数据；
	public Object[] getCountryDataByCityName(String name){
		Object[] countryData =null;
				int i=allCityList.indexOf(name);
				if(i<0)
					return new Object[1];
				countryData=countryList.get(i).toArray();
		return countryData;

	}
	public List<List<String>> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<List<String>> countryList) {
		this.countryList = countryList;
	}
	
	public void lodingDataFromFile(){
		List<String> tempList=new ArrayList<String>();
		List<String> linesList=readFileByLines(pathPrivince);
		for(int i=0;i<linesList.size();i++){
			provinceList=formatLineData(linesList.get(i));
		}
		
		linesList= readFileByLines(pathCity);
		
		for(int i=0;i<linesList.size();i++){
			tempList=formatLineData(linesList.get(i));
			cityList.add(tempList);
		}
		
		//获取每个市的县 字符串，结果是以逗号隔开的
		linesList= readFileByLines(pathCountry);
//问题就在这里...
		for(int i=0;i<linesList.size();i++){
			tempList=formatLineData(linesList.get(i));
			countryList.add(tempList);
		}
		
		
	}
	
	//格式行数据 放于一个链表中
	public  List<String> formatLineData(String linesData){
		List<String> tempStringList =new ArrayList<String>();
		String[] str=linesData.split(",");
		for(int i=0;i<str.length;i++)
			tempStringList.add(str[i]);
		return tempStringList;
	}
	
	 public  List<String> readFileByLines(String fileName) {
		 	//创建一个字符串的链表
		 	InputStream is=this.getClass().getResourceAsStream(fileName);   
	        
	        List<String> tempStringList =new ArrayList<String>();
	        BufferedReader reader = null;
	        try {
	        	 reader=new BufferedReader(new InputStreamReader(is));
	            String tempString = null;
	  
	            while ((tempString = reader.readLine()) != null) {
	                // 显示行号
	            	tempStringList.add(tempString);
	            }
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (reader != null) {
	                try {
	                    reader.close();
	                } catch (IOException e1) {
	                }
	            }
	        }
	        
	        return tempStringList;
	    }
	public List<String> getProvinceList() {
		return provinceList;
	}
	public void setProvinceList(List<String> provinceList) {
		this.provinceList = provinceList;
	}

	public void setCityList(List<List<String>> cityList) {
		this.cityList = cityList;
	}


}
