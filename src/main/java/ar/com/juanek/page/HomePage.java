package ar.com.juanek.page;

import ar.com.juanek.service.ClassicService;
import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 * @author juanekipes@gmail.com
 */
@WicketHomePage
public class HomePage extends WebPage {

    @SpringBean
    private ClassicService classicService;

    public HomePage() {
        System.out.println(""+classicService.findOfficeOrdered());
        System.out.println(""+classicService.productsLessThanMRSP());
    }
}