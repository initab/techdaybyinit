package se.init.tdbi;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import se.init.tdbi.entity.Answer;
import se.init.tdbi.entity.Question;
import se.init.tdbi.entity.Review;
import se.init.tdbi.repository.AnswerRepository;
import se.init.tdbi.repository.QuestionRepository;
import se.init.tdbi.repository.ReviewRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YorickApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testAnswers() {
        Answer entity = new Answer();
        entity.setComment("But why?");

        Answer stored = answerRepository.save(entity);

        Answer result = answerRepository.findOne(stored.getId());

        Assert.assertEquals(entity.getComment(), result.getComment());
    }

    @Test
    public void testQuestions() {
        Question entity = new Question();
        entity.setDisplayText("But why?");

        Question stored = questionRepository.save(entity);

        Question result = questionRepository.findOne(stored.getId());

        Assert.assertEquals(entity.getDisplayText(), result.getDisplayText());
    }
    @Test
    public void testReview() {
        Review entity = new Review();
        entity.setComments("But why?");

        Review stored = reviewRepository.save(entity);

        Review result = reviewRepository.findOne(stored.getId());

        Assert.assertEquals(entity.getComments(), result.getComments());
    }
}
