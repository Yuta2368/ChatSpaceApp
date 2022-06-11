package validations;

import java.util.ArrayList;
import java.util.List;

import models.Topic;

public class TopicValidator {

    public static List<String> validate(Topic t) {
        List<String> errors = new ArrayList<String>();

        String titile = t.getTitle();
        if(titile == null || titile.equals("")) {
        	errors.add("タイトルを入力してください");
        }

        String description = t.getDescription();
        if(description == null || description.equals("")) {
        	errors.add("本文を入力してください");
        }

        return errors;
    }
}
