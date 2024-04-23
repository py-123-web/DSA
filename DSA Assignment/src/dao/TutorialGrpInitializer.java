//package dao;
//
//import adt.*;
//import entity.*;
///**
// *
// * @author Low Jia Yu
// */
////import dao.StudentInitializer;
//import static CourseInitializer.progList;
//import static dao.StudentInitializer.studentList;
//
//public class TutorialGrpInitializer {
//    public static SortedArrayList<TutorialGroup> tutorialGrpList = new SortedArrayList<>(); 
//    public static SortedArrayList<TutorialGroup> tgStudentList = new SortedArrayList<>(); 
//     
//     //private static StudentInitializer studentInitializer = new StudentInitializer();
//    
//    public void insertSampleData() { 
//        //SortedListInterface<Student> studentList = studentInitializer.initializeStudent();
//        
//        tutorialGrpList.add(new TutorialGroup("DACG1", 1, 3, programmeList.getEntry(0))); //DAC
//        tutorialGrpList.add(new TutorialGroup("DACG3", 3, 3, programmeList.getEntry(0)));
//        tutorialGrpList.add(new TutorialGroup("DACG2", 2, 3, programmeList.getEntry(0)));
//        
//        tutorialGrpList.add(new TutorialGroup("DBFG2", 2, 4, programmeList.getEntry(1)));//DBF
//        tutorialGrpList.add(new TutorialGroup("DBFG1", 1, 4, programmeList.getEntry(1)));
//        
//        
//        tutorialGrpList.add(new TutorialGroup("DEEG2", 2, 2, programmeList.getEntry(2))); //DEE
//        tutorialGrpList.add(new TutorialGroup("DEEG1", 1, 2, programmeList.getEntry(2)));
//        
//        tutorialGrpList.add(new TutorialGroup("DMIG1", 1, 5, programmeList.getEntry(3)));//DMI
//        tutorialGrpList.add(new TutorialGroup("DMIG2", 2, 5, programmeList.getEntry(3)));
//        
//        tutorialGrpList.add(new TutorialGroup("REIG2", 2, 2, programmeList.getEntry(4)));//REI
//        tutorialGrpList.add(new TutorialGroup("REIG1", 1, 2, programmeList.getEntry(4)));
//        tutorialGrpList.add(new TutorialGroup("REIG3", 3, 2, programmeList.getEntry(4)));
//        
//        tutorialGrpList.add(new TutorialGroup("RFNG2", 2, 2, programmeList.getEntry(5)));//RFN
//        tutorialGrpList.add(new TutorialGroup("RFNG1", 1, 2, programmeList.getEntry(5)));
//        
//        tutorialGrpList.add(new TutorialGroup("RIDG2", 2, 2, programmeList.getEntry(6)));//RID
//        tutorialGrpList.add(new TutorialGroup("RIDG1", 1, 2, programmeList.getEntry(6)));
//        
//        tutorialGrpList.add(new TutorialGroup("RITG2", 2, 2, programmeList.getEntry(7)));//RIT
//        tutorialGrpList.add(new TutorialGroup("RITG1", 1, 2, programmeList.getEntry(7)));
//        
//        tutorialGrpList.add(new TutorialGroup("RMNG2", 2, 2, programmeList.getEntry(8)));//RMN
//        tutorialGrpList.add(new TutorialGroup("RMNG1", 1, 2, programmeList.getEntry(8)));
//        
//        tutorialGrpList.add(new TutorialGroup("RMTG2", 2, 2, programmeList.getEntry(9))); //RMT
//        tutorialGrpList.add(new TutorialGroup("RMTG1", 1, 2, programmeList.getEntry(9)));
//        
//        tutorialGrpList.add(new TutorialGroup("RSWG2", 2, 3, programmeList.getEntry(10)));//RSW
//        tutorialGrpList.add(new TutorialGroup("RSWG1", 1, 3, programmeList.getEntry(10)));
//        
//        
//
//        tgStudentList.add(new TutorialGroup(studentList.getEntry(0), "DACG1", 1, 3, programmeList.getEntry(0)));
//        tgStudentList.add(new TutorialGroup(studentList.getEntry(19), "DACG1", 1, 3, programmeList.getEntry(0)));
//        //tgStudentList.add(new TutorialGroup(studentList.getEntry(25), "DACG1", 1, 3, programmeList.getEntry(0)));
//        tgStudentList.add(new TutorialGroup(studentList.getEntry(1), "DACG3", 3, 3, programmeList.getEntry(0)));
//        tgStudentList.add(new TutorialGroup(studentList.getEntry(2), "DACG2", 2, 3, programmeList.getEntry(0)));
//       
//        tgStudentList.add(new TutorialGroup(studentList.getEntry(3), "DBFG2", 2, 4, programmeList.getEntry(1)));
//        tgStudentList.add(new TutorialGroup(studentList.getEntry(4), "DBFG1", 1, 4, programmeList.getEntry(1)));
//        
//        tgStudentList.add(new TutorialGroup(studentList.getEntry(5), "DEEG2", 2, 2, programmeList.getEntry(2)));
//        tgStudentList.add(new TutorialGroup(studentList.getEntry(6), "DEEG1", 1, 2, programmeList.getEntry(2)));
//        
//        tgStudentList.add(new TutorialGroup(studentList.getEntry(7), "DMIG1", 1, 5, programmeList.getEntry(3)));
//        tgStudentList.add(new TutorialGroup(studentList.getEntry(8), "DMIG2", 2, 5, programmeList.getEntry(3)));
//        
//        tgStudentList.add(new TutorialGroup(studentList.getEntry(9), "REIG2", 2, 2, programmeList.getEntry(4)));
//        tgStudentList.add(new TutorialGroup(studentList.getEntry(10), "REIG1", 1, 2, programmeList.getEntry(4)));
//        tgStudentList.add(new TutorialGroup(studentList.getEntry(11), "REIG3", 3, 2, programmeList.getEntry(4)));
//        
//        tgStudentList.add(new TutorialGroup(studentList.getEntry(12), "RFNG2", 2, 2, programmeList.getEntry(5)));
//        tgStudentList.add(new TutorialGroup(studentList.getEntry(13), "RFNG1", 1, 2, programmeList.getEntry(5)));
//        tgStudentList.add(new TutorialGroup(studentList.getEntry(14), "RIDG2", 2, 2, programmeList.getEntry(6)));
//        tgStudentList.add(new TutorialGroup(studentList.getEntry(15), "RIDG1", 1, 2, programmeList.getEntry(6)));
//        
//        tgStudentList.add(new TutorialGroup(studentList.getEntry(16), "RITG2", 2, 2, programmeList.getEntry(7)));
//        tgStudentList.add(new TutorialGroup(studentList.getEntry(17), "RITG1", 1, 2, programmeList.getEntry(7)));
//        
//        tgStudentList.add(new TutorialGroup(studentList.getEntry(18), "RMNG2", 2, 2, programmeList.getEntry(8)));
//        tgStudentList.add(new TutorialGroup(studentList.getEntry(19), "RMNG1", 1, 2, programmeList.getEntry(8)));
//        
//        
//        tgStudentList.add(new TutorialGroup(studentList.getEntry(19), "RMTG2", 2, 2, programmeList.getEntry(9)));
//        tgStudentList.add(new TutorialGroup(studentList.getEntry(19), "RMTG1", 1, 2, programmeList.getEntry(9)));
//        
//        tgStudentList.add(new TutorialGroup(studentList.getEntry(19), "RSWG2", 2, 3, programmeList.getEntry(10)));
//        tgStudentList.add(new TutorialGroup(studentList.getEntry(19), "RSWG2", 2, 3, programmeList.getEntry(10)));
//        
//        
//        
//    }
//
//    public SortedArrayList<TutorialGroup> getTutorialGrpList() {
//        return tutorialGrpList;
//    }
//
//    public SortedArrayList<TutorialGroup> getTgStudentList() {
//        return tgStudentList;
//    }
//}
