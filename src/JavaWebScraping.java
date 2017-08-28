import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

public class JavaWebScraping {

	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("http://stdweb2.korean.go.kr/search/View.jsp?idx=421993").get();
		
		Element body = doc.body();
		
		Elements titles		= doc.select(".word_title");	//단어
		Elements NumRG		= doc.select(".NumRG");			//품사
		Elements Definition	= doc.select(".Definition");	//해석
		Elements Use		= doc.select(".Use");			//용례
		
		int nTitleSize	= titles.size();
		int nPosSize	= NumRG.size();
		int nDefSize	= Definition.size();
		int nUseSize	= Use.size();
		
		for(Element e: titles) {
			System.out.println("text: " + e.text());
			//System.out.println("text: " + e.siblingElements().text());
			
			Elements esibling = e.siblingElements();

			for(Element ei: esibling) {
				System.out.println("text: " + ei.text());
			}
					
			//System.out.println("html: " + e.html());
		}
		
		for(Element e: NumRG) {
			System.out.println("text: " + e.text());
			//System.out.println("text: " + e.siblingElements().text());
			
			Elements esibling = e.siblingElements();

			for(Element ei: esibling) {
				//System.out.println("text: " + ei.text());
				
				Elements esibling2 = ei.siblingElements();
				for(Element ei2: esibling2) {
					System.out.println("text: " + ei2.text());	
				}
			}
			
			//System.out.println("html: " + e.html());
		}

		/*
		for(Element e: Definition) {
			System.out.println("text: " + e.text());
			System.out.println("text: " + e.siblingElements().text());
			//System.out.println("html: " + e.html());
		}

		for(Element e: Use) {
			System.out.println("text: " + e.text());
			System.out.println("text: " + e.siblingElements().text());
			//System.out.println("html: " + e.html());
		}
		*/
		
	} //End of main method
} //End of class JavaWebScraping
