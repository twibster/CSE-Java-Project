package backend.functionality;

import backend.constants.MeetingType;
import backend.constants.Positions;
import backend.Validators;
import backend.users.User;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Meeting {
    private static int count;
    public static ArrayList<Meeting> database = new ArrayList<>();
    final int id;
    final User creator;
    private String topic;
    private MeetingType type;
    private String info;
    private LocalDateTime date;
    final LocalDateTime created = LocalDateTime.now();
    public Meeting(User creator, String topic,MeetingType type, String info, LocalDateTime date) throws Exception {
        this.creator = setCreator(creator);
        setTopic(topic);
        setType(type);
        setInfo(info);
        setDate(date);

        this.id = count++;
        database.add(this);
    }
    private User setCreator(User creator) throws Exception {
        Validators.positionValidator(creator.getPosition(), new Positions[]{Positions.ADMIN, Positions.TEACHER});
        return creator;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) throws Exception {
        this.topic = Validators.lengthValidator(topic, 3);
    }

    public MeetingType getType() {
        return type;
    }

    public void setType(MeetingType type) {
        this.type = type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) throws Exception {
        this.info = Validators.lengthValidator(info,8);
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) throws Exception {
        this.date = Validators.deadlineValidator(date);
    }

    public void deleteAssignment(Meeting assignment){
        database.remove(assignment);
        assignment=null;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "id=" + id +
                ", creator_id=" + creator.id+
                ", topic='" + topic + '\'' +
                ", type='" + type + '\'' +
                ", info='" + info + '\'' +
                ", date=" + date +
                ", created=" + created +
                '}';
    }
}
