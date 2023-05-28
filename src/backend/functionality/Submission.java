package backend.functionality;

import backend.Validators;
import backend.constants.Positions;
import backend.users.User;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Submission {
    private static int count;
    public static ArrayList<Submission> database = new ArrayList<>();
    final int id;
    final User creator;
    final Assignment assignment;
    private String body;
    private String attachment=null;
    final LocalDateTime created = LocalDateTime.now();
    public Submission(User creator, Assignment assignment, String body, String attachment) throws Exception {
        this.creator = setCreator(creator);
        this.assignment = assignment;
        setBody(body);
        setAttachment(attachment);

        this.id = count++;
        database.add(this);
    }
    public Submission(User creator, Assignment assignment, String body) throws Exception {
        this.creator = setCreator(creator);
        this.assignment = assignment;
        setBody(body);

        this.id = count++;
        database.add(this);
    }
    private User setCreator(User creator) throws Exception {
        Validators.positionValidator(creator.getPosition(), new Positions[]{Positions.ADMIN, Positions.TEACHER});
        return creator;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) throws Exception {
        this.body = Validators.lengthValidator(body, 3);
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) throws Exception {
        this.attachment = Validators.attachmentValidator(attachment);
    }
    public void deleteAssignment(Submission meeting){
        database.remove(meeting);
        meeting=null;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "id=" + id +
                ", creator_id=" + creator.id+'\'' +
                ", assignment_id=" + assignment.id+'\'' +
                ", body='" + body + '\'' +
                ", attachment=" + attachment+ '\'' +
                ", created=" + created +'\'' +
                '}';
    }
}
