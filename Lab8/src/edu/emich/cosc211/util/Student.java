package edu.emich.cosc211.util;

/**
 * Student class contains information about individual student records.
 *
 * @author eddie gurnee
 *
 */
public class Student {
    private String eid;
    private String name;
    private String year;

    public Student(String name, String eid, String year) {
        super();
        this.name = name;
        this.eid = eid;
        this.year = year;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.eid == null) {
            if (other.eid != null) {
                return false;
            }
        } else if (!this.eid.equals(other.eid)) {
            return false;
        }
        if (this.name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!this.name.equals(other.name)) {
            return false;
        }
        if (this.year == null) {
            if (other.year != null) {
                return false;
            }
        } else if (!this.year.equals(other.year)) {
            return false;
        }
        return true;
    }

    public String getEid() {
        return this.eid;
    }

    public String getName() {
        return this.name;
    }

    public String getYear() {
        return this.year;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((this.eid == null) ? 0 : this.eid.hashCode());
        result = (prime * result) + ((this.name == null) ? 0 : this.name.hashCode());
        result = (prime * result) + ((this.year == null) ? 0 : this.year.hashCode());
        return result;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Student [name=" + this.name + ", eid=" + this.eid + ", year=" + this.year + "]";
    }
}
