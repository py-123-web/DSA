package dao;

import adt.*;
import entity.Student;
import entity.RegisterCourse;
import entity.Course;

/**
 *
 * @author Lee Weng Yan, Low Jia Yu
 */
public class StudentInitializer {

    public SortedListInterface<Student> studentList = new SortedArrayList<>();
    public SortedListInterface<RegisterCourse> registerCourseList = new SortedArrayList<>();
    public SortedListInterface<Course> courseList = new SortedArrayList<>();

    public void initializeStudent() {
        studentList.add(new Student("22WMR23056", "Bryan Tan Jun Han", "030430-07-0084", "MALE", "011-2010202", "bryan@tarc.edu.my", "34 Jalan Emas"));
        studentList.add(new Student("21WMR01237", "Zen Tan Wei Hao", "000912-09-1234", "MALE", "012-2587101", "zen@tarc.edu.my", "33 Jalan Bunga"));
        studentList.add(new Student("22WMR23000", "Esther Zhang Yu Wen", "019314-07-6716", "FEMALE", "012-4032218", "esther@tarc.edu.my", "71 Jalan Perak"));
        studentList.add(new Student("21WMR01231", "Glenn Yong Qi Hang", "001010-10-1090", "MALE", "012-2762101", "glenn@tarc.edu.my", "30 Jalan Permai"));
        studentList.add(new Student("21WMR01239", "Alice Wong Mei Qi", "020112-14-1884", "FEMALE", "012-2456101", "alice@tarc.edu.my", "12 Jalan Maju"));
        studentList.add(new Student("22WMR23001", "Abigail Lee Hui En", "966683-23-9394", "FEMALE", "013-1073784", "huien@tarc.edu.my", "1 Jalan Ampang"));
        studentList.add(new Student("20WMR23002", "Alissa Lim Chee Wen", "012049-30-7261", "FEMALE", "014-5409235", "alissa@tarc.edu.my", "5 Jalan Langkawi"));
        studentList.add(new Student("20WMR23003", "Audrey Soh Pei Li", "035054-07-3095", "FEMALE", "015-2085536", "audrey@tarc.edu.my", "7 Jalan Sultan Ismail"));
        studentList.add(new Student("21WMR23004", "Benjamin Chew Kar Wen", "020430-07-1417", "FEMALE", "016-2000202", "benjamin@tarc.edu.my", "93 Jalan Istana"));
        studentList.add(new Student("22WMR23005", "Bella Yeow Kai Li", "040912-41-3352", "MALE", "017-7301346", "bella@tarc.edu.my", "10 Jalan Hang Tuah"));

        studentList.add(new Student("23WMR23006", "Brandon Low Kai Hua", "035884-14-7657", "MALE", "018-4850327", "brandon@tarc.edu.my", "67 Jalan Bangsa Selatan"));
        studentList.add(new Student("22WMR23007", "Bryan Liew Wei Kai", "039030-14-8097", "MALE", "019-2025297", "bryan@tarc.edu.my", "9 Jalan Bukit Bintang"));
        studentList.add(new Student("22WMR23008", "Brenda Chuah Mei Li", "994862-07-2396", "FEMALE", "011-3029610", "brenda@tarc.edu.my", "8 Jalan Chow Kit"));
        studentList.add(new Student("22WMR23009", "Cody Chee Li Min", "037629-08-5629", "MALE", "012-9044068", "cody@tarc.edu.my", "95 Jalan Imbi"));
        studentList.add(new Student("22WMR23010", "Christina Lau Pei Han", "031869-14-3445", "FEMALE", "013-3552042", "christina@tarc.edu.my", "41 Jalan Cochrane"));
        studentList.add(new Student("22WMR23011", "Crystal Lim See Yan", "022070-02-7288", "FEMALE", "014-3364172", "crystal@tarc.edu.my", "1 Jalan Dewan Bahasa"));
        studentList.add(new Student("20WMR23012", "Charissa Wong Wei Ho", "022070-08-7516", "FEMALE", "015-3449800", "charisan@tarc.edu.my", "86 Jalan Bukit Tinggi"));
        studentList.add(new Student("20WMR23015", "Clement Chen Chow Yan", "023815-14-7409", "FEMALE", "011-8529891", "clement@tarc.edu.my", "32 Jalan Dang Wangi"));
        studentList.add(new Student("20WMR23056", "Dexter Tan Seng Kit", "023887-03-4147", "MALE", "011-9318631", "dexter@tarc.edu.my", "3 Jalan Aman"));
        studentList.add(new Student("20WMR23033", "Danial See Han Wai", "021636-07-2938", "MALE", "011-2286956", "danial@tarc.edu.my", "5 Jalan Bunga"));
    }
    

}