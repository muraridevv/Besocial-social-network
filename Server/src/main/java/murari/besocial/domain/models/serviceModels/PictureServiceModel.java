package murari.besocial.domain.models.serviceModels;

import java.time.LocalDateTime;

import murari.besocial.domain.entities.User;

public class PictureServiceModel {
    private String id;
    private String description;
    private User user;
    private String imageUrl;
    private LocalDateTime time;
    private String cloudinaryPublicId;

    public PictureServiceModel() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public String getCloudinaryPublicId() {
        return this.cloudinaryPublicId;
    }

    public void setCloudinaryPublicId(String cloudinaryPublicId) {
        this.cloudinaryPublicId = cloudinaryPublicId;
    }
}
