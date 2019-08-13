package com.nplat.convert.entity;

public class PlatformSvg {
    private Long id;

    private Long sCount;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getsCount() {
        return sCount;
    }

    public void setsCount(Long sCount) {
        this.sCount = sCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}