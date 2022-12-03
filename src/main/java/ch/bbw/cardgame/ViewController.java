package ch.bbw.cardgame;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * ViewController
 *    Kontrolliert Zusammenspiel mit der View
 * @author Martin Atanasov
 * @date 26.08.2021
 */
@Controller
public class ViewController {
    List<Flugzeug> leftFlugzeugList = new ArrayList<>();
    List<Flugzeug> rightFlugzeugList = new ArrayList<>();
    Flugzeug leftFlugzeug = null;
    Flugzeug rightFlugzeug = null;

    public ViewController() {
        setup();
    }

    private void setup(){
        leftFlugzeugList.clear();
        rightFlugzeugList.clear();

        //Aufwendiger Style
        Flugzeug Flugzeug1 = new Flugzeug("images/flugzeug4.jpg", "Lockheed C-5 Galaxy", 45.1, 579.00 );
        leftFlugzeugList.add(Flugzeug1);
        Flugzeug Flugzeug2 = new Flugzeug("images/flugzeug3.jpg", "Boeing 747-8", 75.54, 833 );
        leftFlugzeugList.add(Flugzeug2);

        //Objekt direkt erstellen
        rightFlugzeugList.add(new Flugzeug("images/flugzeug2.jpg", "Bristol Brabazon", 52.00, 404.00 ));
        rightFlugzeugList.add(new Flugzeug("images/flugzeug1.jpg", "Convair XC-99", 55.64, 400.00 ));
    }

    @GetMapping("/")
    public String redirect() {
        Flugzeug leftFlugzeug = null;
        Flugzeug rightFlugzeug = null;
        return "redirect:/cardGameView";
    }

    @GetMapping("/cardGameView")
    public String showView(Model model) {
        model.addAttribute("leftFlugzeug", leftFlugzeug);
        model.addAttribute("rightFlugzeug", rightFlugzeug);
        model.addAttribute("numberLeft", leftFlugzeugList.size());
        model.addAttribute("numberRight", rightFlugzeugList.size());
        return "cardGameForm";
    }

    @PostMapping(value = "/cardGameView", params = {"showButton=showLeft"})
    public String showLeftCard(Model model) {
        if(leftFlugzeugList.isEmpty()){
            leftFlugzeug = null;
        }else{
            leftFlugzeug = leftFlugzeugList.get(0);
        }
        model.addAttribute("leftFlugzeug", leftFlugzeug);
        model.addAttribute("rightFlugzeug", rightFlugzeug);
        model.addAttribute("numberLeft", leftFlugzeugList.size());
        model.addAttribute("numberRight", rightFlugzeugList.size());
        return "cardGameForm";
    }

    @PostMapping(value = "/cardGameView", params = {"moveButton=moveToLeft"})
    public String moveCardToLeft(Model model) {
        if(rightFlugzeugList.isEmpty()){
            //do nothing
        }else{
            //Verliererkarte hinzufügen
            leftFlugzeugList.add(rightFlugzeugList.remove(0));
            //Siegerkarte nach hinten schieben
            leftFlugzeugList.add(leftFlugzeugList.remove(0));
        }
        leftFlugzeug = null;
        rightFlugzeug = null;
        model.addAttribute("leftFlugzeug", leftFlugzeug);
        model.addAttribute("rightFlugzeug", rightFlugzeug);
        model.addAttribute("numberLeft", leftFlugzeugList.size());
        model.addAttribute("numberRight", rightFlugzeugList.size());
        return "cardGameForm";
    }

    @PostMapping(value = "/cardGameView", params = {"showButton=showRight"})
    public String showRightCard(Model model) {
        if(rightFlugzeugList.isEmpty()){
            rightFlugzeug = null;
        }else{
            rightFlugzeug = rightFlugzeugList.get(0);
        }
        model.addAttribute("leftFlugzeug", leftFlugzeug);
        model.addAttribute("rightCar", rightFlugzeug);
        model.addAttribute("numberLeft", leftFlugzeugList.size());
        model.addAttribute("numberRight", rightFlugzeugList.size());
        return "cardGameForm";
    }

    @PostMapping(value = "/cardGameView", params = {"moveButton=moveToRight"})
    public String moveCardToRight(Model model) {
        if (leftFlugzeugList.isEmpty()) {
            //do nothing
        } else {
            //Verliererkarte hinzufügen
            rightFlugzeugList.add(leftFlugzeugList.remove(0));
            //Siegerkarte nach hinten schieben
            rightFlugzeugList.add(rightFlugzeugList.remove(0));
        }
        leftFlugzeug = null;
        rightFlugzeug = null;
        model.addAttribute("leftFlugzeug", leftFlugzeug);
        model.addAttribute("rightFlugzeug", rightFlugzeug);
        model.addAttribute("numberLeft", leftFlugzeugList.size());
        model.addAttribute("numberRight", rightFlugzeugList.size());
        return "cardGameForm";
    }

    @PostMapping(value = "/cardGameView", params = {"showButton=reset"})
    public String resetView(Model model) {
        setup();
        leftFlugzeug = null;
        rightFlugzeug = null;
        model.addAttribute("leftFlugzeug", leftFlugzeug);
        model.addAttribute("rightFlugzeug", rightFlugzeug);
        model.addAttribute("numberLeft", leftFlugzeugList.size());
        model.addAttribute("numberRight", rightFlugzeugList.size());
        return "cardGameForm";
    }

}
