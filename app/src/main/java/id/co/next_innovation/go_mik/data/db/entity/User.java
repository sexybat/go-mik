/*
 * Copyright 2018 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2018
 */

package id.co.next_innovation.go_mik.data.db.entity;


import android.arch.persistence.room.PrimaryKey;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "user")
public class User {

    private int id;
    private String name;
    private String email;
    @Generated(hash = 504641517)
    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
