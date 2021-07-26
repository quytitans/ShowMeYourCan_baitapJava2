package ShowMeYourCan;

import ShowMeYourCan.Unity.Teacher;
import ShowMeYourCan.model.readFile;

import java.util.*;

public class MainThread {
    public static void main(String[] args) {
        readFile readFile = new readFile();
        Map<String, Teacher> hashMap = new HashMap();
        List<Teacher> database = new ArrayList<>();
        List<Teacher> finalTeacher = new ArrayList<>();

        //lay thong tin tu file vao arrylist
        database = readFile.readFile();
        //day thong tin vao hashmap cap nhat thong tin trung lap
        for (Teacher teacher : database
        ) {
            if (hashMap.containsKey(teacher.getID())) {
                Teacher teacherHashMap = hashMap.get(teacher.getID());
                hashMap.remove(teacher.getID());
                teacherHashMap.setQuantity(teacherHashMap.getQuantity() + teacher.getQuantity());
                long dateHashMap = teacherHashMap.getDateMilisecond();
                long dateDataBase = teacher.getDateMilisecond();
                if (dateDataBase > dateHashMap) {
                    teacherHashMap.setMilisecDate(dateDataBase);
                }
                hashMap.put(teacherHashMap.getID(), teacherHashMap);
            } else {
                hashMap.put(teacher.getID(), teacher);
            }
        }
        Set<String> keySet = hashMap.keySet();
        for (String key : keySet) {
            Teacher teacher2 = hashMap.get(key);
            finalTeacher.add(teacher2);
        }
        //sắp xếp các phần tử trong finalTeacher
        Collections.sort(finalTeacher, new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                return o1.getQuantity() < o2.getQuantity() ? 1 : -1;
            }
        });
        //show 3 nguoi an nhieu nhat
        System.out.println("Top 3 giang vien beo nhat do an nhieu la: ");
        for (int i = 0; i < 2; i++) {
            System.out.println(finalTeacher.get(i).getID() + "|" + finalTeacher.get(i).getFullName() + "|" + finalTeacher.get(i).getQuantity());
        }
        //xu ly truong hop ho an so luong bang nhau
        if (finalTeacher.get(2).getQuantity() == finalTeacher.get(3).getQuantity()) {
            if (finalTeacher.get(2).getDateMilisecond() <= finalTeacher.get(3).getDateMilisecond()) {
                System.out.println(finalTeacher.get(2).getID() + "|" + finalTeacher.get(2).getFullName() + "|" + finalTeacher.get(2).getQuantity());
            } else {
                System.out.println(finalTeacher.get(3).getID() + "|" + finalTeacher.get(3).getFullName() + "|" + finalTeacher.get(3).getQuantity());
            }
        } else {
            System.out.println(finalTeacher.get(2).getID() + "|" + finalTeacher.get(2).getFullName() + "|" + finalTeacher.get(2).getQuantity());
        }
    }
}
