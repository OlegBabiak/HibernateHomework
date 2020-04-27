package hib.hw.fromLesson15.oneToMany;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private int id;

    @Column(name = "post_title")
    private String title;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "post")
    private Set<Comment> comments;

    public Post(String title) {
        this.title = title;
    }

    public Post() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", comments=" + comments +
                '}';
    }
}
