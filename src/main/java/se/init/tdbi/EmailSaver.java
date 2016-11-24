package se.init.tdbi;

import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.stereotype.Component;
import se.init.tdbi.entity.Review;

@Component
@SuppressWarnings("unused")
public class EmailSaver extends AbstractRepositoryEventListener<Review> {

    @Override
    protected void onBeforeSave(Review entity) {
        String headerEmail = EmailHeaderInterceptor.getEmail();
        if (headerEmail != null && ! headerEmail.isEmpty()) {
            entity.setEmail(headerEmail);
        }
    }

    @Override
    protected void onBeforeCreate(Review entity) {
        String headerEmail = EmailHeaderInterceptor.getEmail();
        if (headerEmail != null && ! headerEmail.isEmpty()) {
            entity.setEmail(headerEmail);
        }
    }
}
