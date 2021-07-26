package ShowMeYourCan.model;

import ShowMeYourCan.Unity.Teacher;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class readFile {
    public List readFile() {
        List<Teacher> dataLists = new ArrayList();
        String url = "D:\\Project_Java\\ShowMeYourCan\\File\\inputData.txt";
        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;
        try {
            //xac dinh file can nhap vao
            fileInputStream = new FileInputStream(url);
            //apply cong cu doc file
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            //doc dong dau tien va loai no ra vi la title
            bufferedReader.readLine();
            //doc dong du lieu dau tien
            String line = bufferedReader.readLine();
            while (line != null) {
                String gvFullName = null;
                String gvID = null;
                String gvDate = null;
                int gvQuantity = 0;
//                Pattern and Matcher
                //lay ra Full Name
                Pattern patternFullName = Pattern.compile("([aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆfFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTuUùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ]{2,7} )+");
                Matcher matcherFullname = patternFullName.matcher(line);
                //lay ID
                Pattern patternID = Pattern.compile("GV[0-9]{3}");
                Matcher matcherID = patternID.matcher(line);
                //lay ra Date
                Pattern patternDate = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}");
                Matcher matcherDate = patternDate.matcher(line);
                //lay ra so luong
                Pattern patternQuantity = Pattern.compile("(?<=^|\\s)[0-9]+(?=$|\\s)");
                Matcher matcherQuantity = patternQuantity.matcher(line);
                //tim kiem thong tin trong line
                if (matcherFullname.find()) {
                    gvFullName = line.substring(matcherFullname.start(), matcherFullname.end());
                }
                if (matcherID.find()) {
                    gvID = line.substring(matcherID.start(), matcherID.end());
                }
                if (matcherDate.find()) {
                    gvDate = line.substring(matcherDate.start(), matcherDate.end());
                }
                if (matcherQuantity.find()) {
                    String gvQuantityStr = line.substring(matcherQuantity.start(), matcherQuantity.end());
                    gvQuantity = parseInt(gvQuantityStr);
                }
                Teacher obj = new Teacher(gvID, gvFullName, gvDate, gvQuantity);
                dataLists.add(obj);
                //doc tiep dong tiep theo
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return dataLists;
    }
}
