package sample.cafekiosk.spring.domain.history.mail;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sample.cafekiosk.spring.domain.BaseEntity;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class MailSendHistory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromMail;
    private String toMail;
    private String subject;
    private String content;

    @Builder
    private MailSendHistory(String fromMail, String toMail, String subject, String content) {
        this.fromMail = fromMail;
        this.toMail = toMail;
        this.subject = subject;
        this.content = content;
    }

}
