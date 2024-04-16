package entity;

/**
 *
 * @author Hor Pei Yu
 */
public class Programme implements Comparable<Programme> {

    private String programmeCode;
    private String programmeName;

    public Programme(String programmeCode, String programmeName) {
        this.programmeCode = programmeCode;
        this.programmeName = programmeName;
    }

    public Programme(String programmeCode) {
        this.programmeCode = programmeCode;
    }

    public String getProgrammeCode() {
        return programmeCode;
    }

    public void setProgrammeCode(String programmeCode) {
        this.programmeCode = programmeCode;
    }

    public String getProgrammeName() {
        return programmeName;
    }

    public void setProgrammeName(String programmeName) {
        this.programmeName = programmeName;
    }

    @Override
    public int compareTo(Programme o) {
        return this.programmeCode.compareTo(o.programmeCode);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Programme otherProgramme = (Programme) obj;

        if ((programmeCode == null && otherProgramme.programmeCode != null)
                || (programmeCode != null && !programmeCode.equals(otherProgramme.programmeCode))) {
            return false;
        }

        if ((programmeCode == null && otherProgramme.programmeCode != null)
                || (programmeCode != null && !programmeCode.equals(otherProgramme.programmeCode))) {
            return false;
        }

        return true;
    }

}
