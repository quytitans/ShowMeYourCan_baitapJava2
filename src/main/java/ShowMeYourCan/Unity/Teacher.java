package ShowMeYourCan.Unity;

import ShowMeYourCan.Util.DateTimeMilisecond;
import ShowMeYourCan.Util.MilisecToDateTime;

import java.util.Date;

public class Teacher {
    String ID;
    String fullName;
    String updateDate;
    int quantity;

    public Teacher() {
    }

    public Teacher(String ID, String fullName, String updateDate, int quantity) {
        this.ID = ID;
        this.fullName = fullName;
        this.updateDate = updateDate;
        this.quantity = quantity;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public long getDateMilisecond() {
        return DateTimeMilisecond.convertToMillisec(this.updateDate);
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
    public void setMilisecDate(long updateDate) {
        this.updateDate = MilisecToDateTime.convertToDateTime(updateDate);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
