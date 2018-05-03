package ua.singleton.buyabook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.singleton.buyabook.dao.AuthorDao;
import ua.singleton.buyabook.model.Author;

@Controller
public class HomeController {

    @Autowired
    private AuthorDao authorDao;

    @GetMapping("/")
    @ResponseBody
    public String getHomePage() {
        StringBuilder output = new StringBuilder("------------------</br>");
        for(Author author : authorDao.getAllAuthors()) {
            output
                    .append(author.getId())
                    .append(" ")
                    .append(author.getFirstName())
                    .append(" ")
                    .append(author.getLastName())
                    .append("</br>");
        }
        output.append("------------------</br>");
        return output.toString();
    }
}
