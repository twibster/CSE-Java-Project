package backend.functionality;

import backend.constants.Positions;
import backend.Validators;
import backend.users.User;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Assignment{
    private static int count;
    public static ArrayList<Assignment> database = new ArrayList<>();
    final int id;
    final User creator;
    private String title;
    private String body;
    private String attachment=null;
    private LocalDateTime deadline;
    final LocalDateTime created = LocalDateTime.now();
    public Assignment(User creator, String title, String body, String attachment, LocalDateTime deadline) throws Exception {
        this.creator = this.setCreator(creator);
        setTitle(title);
        setBody(body);
        setAttachment(attachment);
        setDeadline(deadline);

        this.id = count++;
        database.add(this);
    }
    public Assignment(User creator, String title, String body, LocalDateTime deadline) throws Exception {
        this.creator = this.setCreator(creator);
        setTitle(title);
        setBody(body);
        setDeadline(deadline);

        this.id = count++;
        database.add(this);
    }
    private User setCreator(User creator) throws Exception {
        Validators.positionValidator(creator.getPosition(), new Positions[]{Positions.ADMIN, Positions.TEACHER});
        return creator;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws Exception {
        this.title = Validators.lengthValidator(title, 3);
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) throws Exception {
        this.body = Validators.lengthValidator(body,20);
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) throws Exception {
        this.attachment = Validators.attachmentValidator(attachment);
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) throws Exception {
        this.deadline = Validators.deadlineValidator(deadline);
    }

    public void deleteAssignment(Assignment assignment){
        database.remove(assignment);
        assignment=null;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "id=" + id +
                ", creator_id=" + creator.id+
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", attachment='" + attachment + '\'' +
                ", deadline=" + deadline +
                ", created=" + created +
                '}';
    }
}
