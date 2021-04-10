package murari.besocial.domain.models.serviceModels;

import java.time.LocalDateTime;
import java.util.List;

import murari.besocial.domain.entities.Comment;
import murari.besocial.domain.entities.Like;
import murari.besocial.domain.entities.User;

public class PostServiceModel {
    private String id;
    private User loggedInUser;
    private User timelineUser;
    private String content;
    private String imageUrl;
    private LocalDateTime time;
    private List<Like> like;
    private List<Comment> commentList;


    public PostServiceModel() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getLoggedInUser() {
        return this.loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public User getTimelineUser() {
        return this.timelineUser;
    }

    public void setTimelineUser(User timelineUser) {
        this.timelineUser = timelineUser;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDateTime getTime() {
        return this.time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public List<Like> getLike() {
        return this.like;
    }

    public void setLike(List<Like> like) {
        this.like = like;
    }

    public List<Comment> getCommentList() {
        return this.commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
