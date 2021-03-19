package croll;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import service.CrollService;

public class Navercroll {

	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("https://comic.naver.com/webtoon/weekday.nhn").get();
		ArrayList<String> title_list = new ArrayList<String>();
		ArrayList<String> href_list = new ArrayList<String>();
		ArrayList<String> img_list = new ArrayList<String>();

		for (int i = 1; i < 8; i++) {
			String filename = "";
			if (i == 1) {
				filename = "mon";
			} else if (i == 2) {
				filename = "tue";
			} else if (i == 3) {
				filename = "wed";
			} else if (i == 4) {
				filename = "thu";
			} else if (i == 5) {
				filename = "fri";
			} else if (i == 6) {
				filename = "sat";
			} else if (i == 7) {
				filename = "sun";
			}
			Elements title = doc
					.select("#content > div.list_area.daily_all > div:nth-child(" + i + ") > div > ul > li > a");

			int title_size = title.size();
			System.out.println(title_size);
			int j = 1;
			for (Element a : title) {
				String title_str = a.text();
				System.out.println(title_str);
				title_list.add(title_str);
				Elements link = doc.select("#content > div.list_area.daily_all > div:nth-child(" + i
						+ ") > div > ul > li:nth-child(" + j + ") > div > a");

				for (Element b : link) {
					String href = b.attr("href");
					System.out.println(href);
					href_list.add(href);
				}

				Elements img_element = doc.select("#content > div.list_area.daily_all > div:nth-child(" + i
						+ ") > div > ul > li:nth-child(" + j + ") > div > a > img");
				Elements img = img_element.select("img");
				System.out.println(img.text());

				for (Element b : img) {
					String url = b.getElementsByAttribute("src").attr("src");// src를 파싱하여 저장
					System.out.println(filename);
					System.out.println(url);
					String extension = url.substring(url.lastIndexOf("."));
					if (extension.equals(".jpg")) {
						URL imgUrl = new URL(url);// 이미지 저장하기위해 파싱한 src를 이용해 URL을 만든다.
						BufferedImage jpg = ImageIO.read(imgUrl);// 이미지를 가져온다.
						File file = new File("C:\\image\\" + filename + j + ".jpg");// 가져온 이미지 저장할 경로설정.
						ImageIO.write(jpg, "jpg", file);// 이미지를 저장한다.
					} else if (extension.equals(".png")) {
						URL imgUrl = new URL(url);// 이미지 저장하기위해 파싱한 src를 이용해 URL을 만든다.
						BufferedImage png = ImageIO.read(imgUrl);// 이미지를 가져온다.
						File file = new File("C:\\image\\" + filename + j + ".png");// 가져온 이미지 저장할 경로설정.
						ImageIO.write(png, "png", file);// 이미지를 저장한다.
					} else if (extension.equals(".gif")) {
						URL imgUrl = new URL(url);// 이미지 저장하기위해 파싱한 src를 이용해 URL을 만든다.
						BufferedImage gif = ImageIO.read(imgUrl);// 이미지를 가져온다.
						File file = new File("C:\\image\\" + filename + j + ".gif");// 가져온 이미지 저장할 경로설정.
						ImageIO.write(gif, "gif", file);// 이미지를 저장한다.
					}
					
					String img_str = filename+j+extension;
					System.out.println(img_str);
					img_list.add(img_str);
					
				}
				j++;
			}

			System.out.println("------------------------------");

		}
		System.out.println();
		System.out.println("t_size: "+title_list.size());
		System.out.println("h_size: "+href_list.size());
		System.out.println("i_size: "+img_list.size());
		CrollService se = new CrollService();
		se.naver(title_list,href_list,img_list);
	}
}