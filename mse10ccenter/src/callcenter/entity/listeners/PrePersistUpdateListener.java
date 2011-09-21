package callcenter.entity.listeners;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import callcenter.entity.products.Hardware;
import callcenter.entity.products.Software;

public class PrePersistUpdateListener {

    @PrePersist
    @PreUpdate
    public void updatePicture(Software software) {

    }

    @PrePersist
    @PreUpdate
    public void updatePicture(Hardware hardware) {

    }
}
