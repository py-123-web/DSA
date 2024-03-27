
package entity;

/**
 *
 * @author syhor
 */
public class Programme implements Comparable<Programme> {
    private String programmeCode;
    private String programmeName;

    public Programme(String programmeCode, String programmeName) {
        this.programmeCode = programmeCode;
        this.programmeName = programmeName;
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
    return programmeCode.compareTo(o.programmeCode);
  }
    
    
    
}
