package validations;

import java.util.ArrayList;
import java.util.List;

import models.Comment;

public class CommentValidator {

    public static List<String> validate(Comment c) {
        List<String> errors = new ArrayList<String>();

        String content = c.getContent();
        if(content == null || content.equals("")) {
        	errors.add("コメントを入力してください");
        }

        return errors;
    }
}
