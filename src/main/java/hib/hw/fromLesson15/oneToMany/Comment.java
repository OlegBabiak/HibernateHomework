package hib.hw.fromLesson15.oneToMany;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int id;

    @Column(name = "author_Name")
    private String authorName;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Comment(String authorName) {
        this.authorName = authorName;
    }

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", post=" + post +
                '}';
    }
}
