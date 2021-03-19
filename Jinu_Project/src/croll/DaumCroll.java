package croll;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import service.CrollService;

public class DaumCroll {

	public static void main(String[] args) throws IOException {
		
		ArrayList<String> title_list = new ArrayList<String>();
		ArrayList<String> nickname_list = new ArrayList<String>();
		ArrayList<String> imgurl_list = new ArrayList<String>();
		ArrayList<String> day_list = new ArrayList<String>();
			
		for(int i = 0; i<7; i++) {
			String day = "";
			if(i==0) {
				day = "mon";
			}else if(i==1){
				day = "tue";
			}else if(i==2){
				day = "wed";
			}else if(i==3){
				day = "thu";
			}else if(i==4){
				day = "fri";
			}else if(i==5){
				day = "sat";
			}else if(i==6){
				day = "sun";
			}
		
		
		Document doc = Jsoup.connect("http://webtoon.daum.net/data/pc/webtoon/list_serialized/"+day+"?").ignoreContentType(true).get();
		
		JSONParser jsonParser1 = new JSONParser();
        JSONObject jsonObject1;
 
        try {
            
            jsonObject1 = (JSONObject) jsonParser1.parse(doc.text());
  
            JSONArray jsonArray1 = (JSONArray) jsonObject1.get("data");
      
            for(int j=0; j<jsonArray1.size(); j++){           
                JSONObject objectInArray = (JSONObject) jsonArray1.get(j);
                String title = objectInArray.get("title").toString();//제목
                String nickname =  objectInArray.get("nickname").toString();//nickname(url접속주소역할)
                JSONObject objectInArray2 = (JSONObject) objectInArray.get("pcThumbnailImage");//이미지 url이 있는 json
                String imgurl = objectInArray2.get("url").toString();//img url
                System.out.println("title: "+title);
                System.out.println("nickname: "+nickname);
                System.out.println("imgurl"+imgurl);
                title_list.add(title);
                nickname_list.add(nickname);
                imgurl_list.add(imgurl);
                day_list.add(day);
                
            }
             
        } catch (ParseException e) {
            e.printStackTrace();
        }
		}
        System.out.println(title_list.size());
        System.out.println(nickname_list.size());
        System.out.println(imgurl_list.size());
        System.out.println(day_list.size());
		
		CrollService se = new CrollService();
		se.daum(title_list, nickname_list, imgurl_list, day_list);

	}
}