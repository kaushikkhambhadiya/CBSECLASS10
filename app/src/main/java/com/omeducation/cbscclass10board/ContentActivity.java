package com.omeducation.cbscclass10board;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.firebase.analytics.FirebaseAnalytics;

import static com.omeducation.cbscclass10board.Config.clickNumber;

public class ContentActivity extends AppCompatActivity {

    GridView grid_view;
//    public Integer[] content_icons = {R.drawable.syllabus, R.drawable.sample_paper, R.drawable.test_paper, R.drawable.notes, R.drawable.imp,
//            R.drawable.value_based_icon, R.drawable.ncrt_solution, R.drawable.video};
//    public String[] content_names = {"CBSE\nSyllabus", "Sample\nPapers", "Test\nPapers", "Revision\nNotes", "Important\nNotes", "Value_based\nExample", "NCERT Book\nSolutions",
//            "Video\nTutorial"};

    public String[] content_names_maths = {"CBSE\nSyllabus", "Ncert\nbook","Sample\nPapers","Previous_Year_Papers_solution", "Revision\nNotes", "Important\nNotes","NCERT Book\nSolutions", "NCERT \nExample", "RD Sharma \n Solution", "Rs Agarwal\nsolution","Video\ntutorial"
            };
    public Integer[] content_icons_maths = {R.drawable.syllabus, R.drawable.ncert,R.drawable.sample_paper, R.drawable.paperset,
            R.drawable.notes, R.drawable.imp, R.drawable.ncrt_solution, R.drawable.ncrt_solution, R.drawable.rsagar, R.drawable.rd_sharma, R.drawable.video};

    public String[] content_names_science = {"CBSE\nSyllabus", "Ncert\nbook","Sample\nPapers","Previous_Year_Papers_solution","Revision\nNotes", "Important\nNotes","NCERT Book\nSolutions", "NCERT \nExample","Video\ntutorial"
    };
    public Integer[] content_icons_science = {R.drawable.syllabus, R.drawable.ncert,R.drawable.sample_paper, R.drawable.paperset,
            R.drawable.notes, R.drawable.imp, R.drawable.ncrt_solution, R.drawable.ncrt_solution,R.drawable.video};


    public Integer[] content_icons_social = {R.drawable.syllabus, R.drawable.ncert,R.drawable.sample_paper, R.drawable.paperset,
            R.drawable.notes,R.drawable.ncrt_solution, R.drawable.ncrt_solution,R.drawable.video};

    public String[] content_names_social = {"CBSE\nSyllabus", "Ncert\nbook","Sample\nPapers","Previous_Year_Papers_solution","Revision\nNotes","NCERT Book\nSolutions","Video\ntutorial"
    };
    public Integer[] content_icons_English_commutative = {R.drawable.syllabus,R.drawable.sample_paper, R.drawable.paperset,
            R.drawable.notes,R.drawable.video};

    public String[] content_names_English_commutative = {"CBSE\nSyllabus","Sample\nPapers","Previous_Year_Papers_solution","Revision\nNotes","Video\ntutorial"
    };

    public Integer[] content_icons_English_language = {R.drawable.syllabus, R.drawable.ncert,R.drawable.sample_paper, R.drawable.paperset,
            R.drawable.ncrt_solution,R.drawable.video};


    public String[] content_names_English_language = {"CBSE\nSyllabus", "Ncert\nbook","Sample\nPapers","Previous_Year_Papers_solution","NCERT Book\nSolutions","Video\ntutorial"
    };


    public Integer[] content_icons_hindiA = {R.drawable.syllabus, R.drawable.ncert,R.drawable.sample_paper, R.drawable.paperset,
            R.drawable.ncrt_solution,R.drawable.video};

    public String[] content_names_hindiA = {"CBSE\nSyllabus", "Ncert\nbook","Sample\nPapers","Previous_Year_Papers_solution","NCERT Book\nSolutions","Video\ntutorial"
    };

    public Integer[] content_icons_hindiB = {R.drawable.syllabus, R.drawable.ncert,R.drawable.sample_paper, R.drawable.paperset,
            R.drawable.ncrt_solution,R.drawable.video};

    public String[] content_names_hindiB = {"CBSE\nSyllabus","Ncert\nbook","Sample\nPapers","Previous_Year_Papers_solution","NCERT Book\nSolutions","Video\ntutorial"
    };

    public Integer[] content_icons_sanskrit = {R.drawable.syllabus, R.drawable.ncert,R.drawable.sample_paper, R.drawable.paperset,
            R.drawable.ncrt_solution};


    public String[] content_names_sanskrit = {"CBSE\nSyllabus", "Ncert\nbook","Sample\nPapers","Previous_Year_Papers_solution","NCERT Book\nSolutions"
    };
    int subject_position;
    String sub_name;
    Toolbar toolbar;


    //cbse_class_10

    String[] mathsSyllabus = {"https://drive.google.com/open?id=1kdVnUfZ4rb4lS4Yria6cGvr6vFqPRL2O"};

    String[] Mathsvideo = {"Real Numbers", "Polynomials", "Pairs in Linear Equations in Two Variables", "Quadratic Equations",
            "Arithmetic Progression", "Triangles", "Coordinate Geometry", "Introduction Trigonmetry", "Some Applications Of Trigonmetry",
            "Circles", "Constructions", "Area Related to Circles", "Surface Areas and Volumes", "Statistics", "Probability"};

    String[] MathsNotes = {"Real Numbers", "Polynomials", "Pairs in Linear Equations in Two Variables", "Quadratic Equations",
            "Arithmetic Progression", "Triangles", "Coordinate Geometry", "Introduction Trigonmetry","application of trignometry",
            "Circles", "Constructions", "Area Related to Circles", "Surface Areas and Volumes", "Statistics", "Probability"};

    String[] MathsNotes111 = {"Real Numbers", "Polynomials", "Pairs in Linear Equations in Two Variables", "Quadratic Equations",
            "Arithmetic Progression", "Triangles", "Coordinate Geometry", "Introduction Trigonmetry","Trignometry application",
            "Circles", "Constructions", "Area Related to Circles", "Surface Areas and Volumes", "Statistics", "Probability"};

    String[] MathsNotes23 = {"Real Numbers", "Polynomials", "Pairs in Linear Equations in Two Variables", "Quadratic Equations",
            "Arithmetic Progression", "Triangles", "Coordinate Geometry", "Introduction Trigonmetry", "Some Applications Of Trigonmetry",
            "Circles", "Constructions", "Area Related to Circles", "Surface Areas and Volumes", "Statistics" ,"Probability"};

    String[] MathsNotes555 = {"Real Numbers", "Polynomials", "Pairs in Linear Equations in Two Variables", "Quadratic Equations",
            "Arithmetic Progression", "Triangles", "Coordinate Geometry", "Introduction Trigonmetry&application",
            "Circles", "Constructions", "Area Related to Circles", "Surface Areas and Volumes", "Statistics & Probability"};

    public String[] sample_paper_maths = {"sample paper 1 with solution","sample paper 2 with solution","sample paper 3 with solution"};


    String[] mathsPaper = {"https://drive.google.com/file/d/1uWLFhrMgS0hmX9DEPqrBDKt51wyp0s43/view?usp=sharing", "https://drive.google.com/file/d/14_AxAKXS9VStDJsCRX2PoamXnTFIZLpQ/view?usp=sharing", "https://drive.google.com/file/d/1djR2t_pTkH4v0Pfd40AixRWyMiUGGeyw/view?usp=sharing", "https://drive.google.com/open?id=1EbK0X-rs2bcxntzmSBuF4WkhoDw112xS", "https://drive.google.com/open?id=1A3z9O5LjYaqvD8iOt2FNtKggwYD2ur3l", "https://drive.google.com/open?id=1-d6-FiF8jRzYzFcVaubKz2AK3K7gxJdd", "https://drive.google.com/open?id=1OhjoyC_upH6zqvoJ8B-POFlL23_RCEng", "https://drive.google.com/open?id=1_FbTL-HMzgZU-tU8NEe4io58Jxz8Rxyh", "https://drive.google.com/open?id=1TsNVRdu45tnoKK_80lY8KjSlOMPyRUKX"};

    String[] mathsPaperSolution = {"https://drive.google.com/open?id=175Ittr5w_ALLt29kfxw0foMJnbssNmur", "https://drive.google.com/open?id=1mMRCCP9xF-m5ekkBNYCRN3Wyibzi_NSB", "https://drive.google.com/open?id=15zs-HyKnjeMFJAKMgMrJHKY4JmKmhmLz", "https://drive.google.com/open?id=1RhXPBFVBMFtm-dzqnMt-gR-DflCMmVOj", "https://drive.google.com/open?id=1ar_ecWIYxwBEXCLOSVy5ct1Z9EH7weSP", "https://drive.google.com/open?id=1zxG1VpeA5QNSAeEklv3Gk8RFkqiQDlxc", "https://drive.google.com/open?id=1oH9OeqZ3C0XVaCaQ3pKz1mhZJFOVaz4b", "https://drive.google.com/open?id=1Oi5YgVJ53e4ICPPLp_G1vcRbrEtCY1M8", "https://drive.google.com/open?id=1cP-KJCRShzMf-hjR0PDvk612vlUBZ46z"};

    String[] mathsRevisednotes1 = {"https://drive.google.com/open?id=1EfP9o0flxljUVe7ohgyhU91TNf42kyFT",
            "https://drive.google.com/open?id=1Qa2shI2pJTKIfgfIwmLEMhp7e7GbhC-p",
            "https://drive.google.com/open?id=1Nnru1qrM2rEZqRkq9SNI8z9X_M2UoaWc",
            "https://drive.google.com/open?id=1iE2nhInEO1yHlwJO1kGNXAFI0kP8SIn5",
            "https://drive.google.com/open?id=1ozjOq3sApZ5SMJ6Z2et_OOzlR4fkGlte",
            "https://drive.google.com/open?id=1uOaZoy-a5nQKK6nNqXkZoKZjfnhRUDpX",
            "https://drive.google.com/open?id=14NhjqozYdPxKB_0-VkggYZ_opHPTjAmX",
            "https://drive.google.com/open?id=1_VudpO9m5WWaJQszks4PE3p3jvYWVmey",
            "https://drive.google.com/open?id=1shwtYknfqqKyArmd1sBuEVr7zPVxz5Rd",
            "https://drive.google.com/open?id=1JqIsU8vlpQ8pBo3onTWL_bVVd1BMJKLS",
            "https://drive.google.com/open?id=1Dd_jz1k3iqH_wD1Ka9mLP3xMaEfL7K0Q",
            "https://drive.google.com/open?id=196qY8v1f54hsoMYjqUNG_-ot_bd3JQrm",
            "https://drive.google.com/open?id=1jfZ5mxsL8-xQakKBbip7dWP_DHcae0hW",
            "https://drive.google.com/open?id=1WAkZpD0DNkIzXKlgjNnbUvdDdUCCKSZV",
            "https://drive.google.com/open?id=1vW1W5ANeP5L9YJQIRWG9OJwIR9NKN9ko"};

    String[] mathsnewNcertSolution = {"https://drive.google.com/open?id=1C7rWRoFaOiEWbn-M0mss9lKtpnd5PvdI","https://drive.google.com/open?id=1u02wwC_2ABanOY3qiVPs_J8D9Ue5DJCk","https://drive.google.com/open?id=1Qth0fpF-p9Haw_Tipx9A33TI0eR2rFAR","https://drive.google.com/open?id=1XoOcp3-HPLh_IRVEYpMHeoJy4fMaeyjp","https://drive.google.com/open?id=1CQOGVWPVbh1sOdGgD2rHgzUQqvDYu-x_","https://drive.google.com/open?id=1tqUzdZAS2zb1dBQvBlGeLpkbEomZOSa0","https://drive.google.com/open?id=1bRmmYoW3xuJw-ukI7DpJSx69hyhRMK_k","https://drive.google.com/open?id=1WECM5oM3LXLJuWNpGYURAiQuP9Hx7Xxz","https://drive.google.com/open?id=1iTLn3U2wP9Z-oXDcJp4tGwq_sdQXTWT5","https://drive.google.com/open?id=1B2vVEcFIAWK3ZykRQsmrKiocBBAydKZ9","https://drive.google.com/open?id=1NCmQGJWC43ONWIQb7GpVSkFyVFM-N1RU","https://drive.google.com/open?id=15_GoThCe0DVB1DhEFF4uySTefv9Y36fC","https://drive.google.com/open?id=1w4kTtetL_FdwzaeO9Vnu-q_gu89g24gy","https://drive.google.com/open?id=1qiOtNUOnFoROurKMsFU2xF6xUjiyKPD-","https://drive.google.com/open?id=1WMO_DhnC8xyb8MfZLHfkxd3TTQW44wEh"};

    String[] mathsnewNcertSolution_example = {"https://drive.google.com/open?id=1a2KV3zcu12LlFUX8PfHaItbHKNeN1vrI","https://drive.google.com/open?id=10xCYT37f_9QEeZaKCygV_Wanq5oxcfm0","https://drive.google.com/open?id=1hrDiOJPj3hOwn6y8ExDwFITOBQjH8Itp","https://drive.google.com/open?id=1uNX3L2v9p-mZU7qatBhSb0fcNrFaNvC3","https://drive.google.com/open?id=1HLj5LhEYCjGWgDRxfZ9Ea0OatFqCN-xZ","https://drive.google.com/open?id=19pY-qSyxsrkMmdobgYxG6B8oB6NJjIU5","https://drive.google.com/open?id=1RndkcqyHxEaqoNDI3UDDsyq1_9utDnQ2","https://drive.google.com/open?id=1__lun7_vHUu3wyRWZjlBzGNmhgIYqo8Z","https://drive.google.com/open?id=1jVP0SW-mUFaOEEesQvhzx_g6ekahiSZf","https://drive.google.com/open?id=1WpkiTmiK49IM69QUaBmgcteoQi47aXTj","https://drive.google.com/open?id=1FsKXKWfqZ6CkCU6n2HX0T0p8VRbcVKaD","https://drive.google.com/open?id=1GQondeZurRXhYorNwOL1wnhqLVYksO9A","https://drive.google.com/open?id=1yh8iGH7OdQJWWQF0X2voUZbWwGpeSjAy"};

    String[] mathsiwmpo = {"https://drive.google.com/open?id=13qOSod9MV-ticQttKkGurT5Lps4OazZg","https://drive.google.com/open?id=1tyJE1TG-4UwGm2WpCk0HZojS0s2DCgWJ","https://drive.google.com/open?id=1lDZpgU9PvybK8OKGwzZeV8ab3iZsBIyw","https://drive.google.com/open?id=1RoGVkoBqCZ0EiXNqxSwcEiYQgFL_48NE","https://drive.google.com/open?id=1_cm1Jux3IgNiQuckJjkS9ceiy5ssPURn","https://drive.google.com/open?id=1lftVd0vAtoyL0N7Qg3MhBqIj9VVwBhjW","https://drive.google.com/open?id=1q0esuSzUd_3D5hDpF4vIH3rqQsGNR2Jc","https://drive.google.com/open?id=1tFoFOF9AIY8UJXwV9cQiaxxxiZvHBOvS","https://drive.google.com/open?id=1_rPO3kUgOuZh8j_r_JP4zR6AXZzjGrgX","https://drive.google.com/open?id=1lxu2MjxA5MFID9wILAb_flL8JYG0ybnP","https://drive.google.com/open?id=1L6Ld3WpMu15BVPGU65i7RqmEfrrPeOQe","https://drive.google.com/open?id=1j7OS8hTNrTddj98RsQGWgyQL3xxsjU3Y","https://drive.google.com/open?id=1KPtemhEYApTnOvyXemNPkodxdod-4-oD","https://drive.google.com/open?id=1m4WfJ4ToE6yiN_WV41YelWeMcTD47uWI","https://drive.google.com/open?id=1NdzeYdI4-OA-oa3Iz-MbG95lqDI3wjLV"};

    String[] maths_rs_agarwal = {"https://drive.google.com/open?id=1wVRDaxyKvb_AxxvmJbiqc-MAjRxfYaxo","https://drive.google.com/open?id=1caRA3cWMIcGlmlS87tubbmlo1kKvE435","https://drive.google.com/open?id=1k_ITnBjShd48aAEv4NMX9g_Z-1UlKNwX","https://drive.google.com/open?id=18d-nI-1Zx_oMdWxpor8HLyR9DLu_UTli","https://drive.google.com/open?id=12tuo01Sh1DtdhYYE1xCfzBBHymIiGRVs","https://drive.google.com/open?id=1GrOKYWVJ_cojKIeFmCoPFOXzaQkKsbzm","https://drive.google.com/open?id=1rXFYa-8BnlZWOHqOjZor3_V8ucs9_Lcw","https://drive.google.com/open?id=1o8saOJoyciQj41tGAM0U84Ea0-V8GHCj","https://drive.google.com/open?id=1jwjUAZWby7RCIPgpG10jWtRD2qDq_kKZ","https://drive.google.com/open?id=1xh3Y2Vy0JEYXH2foZiYo6jXafVGqT1eK","https://drive.google.com/open?id=1S5Belrvn27Pwi0XMb6Q5CLeTvdkrEuK-","https://drive.google.com/open?id=10aQ2NjCbmfpLDIIEErcAbi7673SHrqOO","https://drive.google.com/open?id=1p-dFBZsyBr6Sdqt6xhXzyA9bIL50eRQ6","https://drive.google.com/open?id=1kFaleQm4ysR6xYUxvMhB3r-7IRs7dPsM","https://drive.google.com/open?id=14tvpdt0H4uVSZUCwmO77ExFbOjan13n0","https://drive.google.com/open?id=1sp56f6b-8e_78uRceOZsL6mH2eTnzqJI","https://drive.google.com/open?id=1iItluZPASRKpyHTtXE8rdJaY8mENGKi_","https://drive.google.com/open?id=1JgTeP8U597w-Kyr5onGwRWh1CNnZ7pXd","https://drive.google.com/open?id=16KDjB3rFPJGugt4Wlk-2fuvBo59wO6R6"};

    String[] maths_rs_agarwal_title = {"ch 1","ch 2","ch 3","ch 4","ch 5","ch 6","ch 7","ch 8","ch 9","ch 10","ch 11","ch 12","ch 13","ch 14","ch 15","ch 16","ch 17","ch 18","ch 19"};

    String[] maths_txt = {"https://drive.google.com/open?id=1GpAeJRW6YmF-hNZQa_tVEaY58fe8Anu7",
            "https://drive.google.com/open?id=1M6wQ7QczDarBS0r_WXKh2_e2MBUNx_C0",
            "https://drive.google.com/open?id=1cC_7ph7x9yVVvNHsqRnNxZ_Qc0vvrU47",
            "https://drive.google.com/open?id=1CbPQ0z8DMg9sESe6lm2DOqN2_ZDZv5-v",
            "https://drive.google.com/open?id=1vbuM1v3h6mmAw1dss3ecpqYIQc_DAzwE",
            "https://drive.google.com/open?id=1Hd97JLKH6BlIGS7hCfkzrwrPSj-nJ9NC",
            "https://drive.google.com/open?id=1g_1X2hPWJWH7EOVeti61iodAbQ7pnFUk",
            "https://drive.google.com/open?id=172Mzbwqadn4_vtvEb0jY-upS50Qf8WXu",
            "https://drive.google.com/open?id=1wd8FKcCnhr8JJE9sPR13_HWSSgi7SL5t",
            "https://drive.google.com/open?id=1mbXwYp4jCXlESDQfAuc2h1-_RMvroKno",
            "https://drive.google.com/open?id=1R6cQQU6iau3F58IVBq6-mkfUqBtqzwuv",
            "https://drive.google.com/open?id=1z1CsMlJmYgoKnpa5r5lQEehWdB_cFt-q",
            "https://drive.google.com/open?id=1erEVU_mclN9PkgX42Xs_v62tvTApD6AV",
            "https://drive.google.com/open?id=197cmqxRxttPURD1M_rz9AFEmcM40m82n",
            "https://drive.google.com/open?id=1NMDLIAdX-5dlBRPPewrYcrRv6lRlNR2e"};


    String[] maths_sample_paper = {"https://drive.google.com/open?id=1-HmGo51hkPxwDAmDFI5aySlt4FIryt36","https://drive.google.com/open?id=1-6v8DvAHqCNsWtJw37j9ulrkuKHZiuqv","https://drive.google.com/open?id=1qb4EWbzKzBZLg3ooMLqu2WqF-4TmCQtr"};
    String[] maths_sample_paper_solution = {"https://drive.google.com/open?id=1WamG95Y5sVPntrHeUZyVG-2hE9e1UNf0","https://drive.google.com/open?id=1x0Zzqqkv5IvshWog8kwYfJe_4IkXwcfV","https://drive.google.com/open?id=14sWplCQ4ykd2EmsURdl-ayDwmw36ErUo"};

    private String[] rd_sharma_title10 = {"Chapter 1 Real Numbers",
            "Chapter 2 Polynomials",
            "Chapter 3 Pair of Linear Equations in Two Variables",
            "Chapter 4 Triangles",
            "Chapter 5 Trigonometric Ratios",
            "Chapter 6 Trigonometric Identities",
            "Chapter 7 Statistics",
            "Chapter 8 Quadratic Equations",
            "Chapter 9 Arithmetic Progressions",
            "Chapter 10 Circles",
            "Chapter 11 Constructions",
            "Chapter 12 Some Applications of Trigonometry",
            "Chapter 13 Probability",
            "Chapter 14 Coordinate Geometry",
            "Chapter 15 Areas Related to Circles",
            "Chapter 16 Surface Areas and Volumes"};

    //class 10



    //science

    // CBSE SCIENCE
    String[] ScienceSyllabus = {"https://drive.google.com/open?id=1GjM5_OANW-f3fzMO7AFr_OKgA6uDQgg6"};

    String[] ScienceNotes = {"Chemical Reactions and Equations", "Acids, Bases and Salts", "Metals and Non-metals", "Carbon and Its Compounds",
            "Periodic Classification of Elements", "Life Processes", " Control and Coordination", " How do Organisms Reproduce?", "Heredity and Evolution",
            "Light Reflection and Refraction", "Human Eye and Colourful World", "Electricity", "Magnetic Effects of Electric Current", "Sources of Energy",
            "Our Environment", "Management of Natural Resources"};



    String[] sci_txt =   {"https://drive.google.com/open?id=1ekb3ilOnjqFwO2hymaYfIP2zbb1VR0AN","https://drive.google.com/open?id=1UkljL15TXIHP97Upxsg-AmWLX7gk-UJc","https://drive.google.com/open?id=1ZfE94LFRizdepeI5cv9rWJla64-NI8HY","https://drive.google.com/open?id=1olGEJcsuxYfrTVwvc6igOeOU4dTeXKn2","https://drive.google.com/open?id=1XyyjmlQKDMunUWCrH2-d6GXvy9Mr5tpP","https://drive.google.com/open?id=1UZ4mKdQGnZ8Hk9crIznjVH_V8sbkWql8","https://drive.google.com/open?id=1m_QzZWTKhLLkl7tL-WJOkKb38gUxrADh","https://drive.google.com/open?id=16VPsFWczZ0qXpA5kmxRRkzJuC0e43mJx","https://drive.google.com/open?id=15S-P1lU5X8LwyQthWO1_Szhgh-9eaDfm","https://drive.google.com/open?id=1YlqScNCgFfMDBQGCVfj3KuAhqeL-EJO9","https://drive.google.com/open?id=1kOr8VRnXZXBMzycvjEH7EnudlJPF3GVf","https://drive.google.com/open?id=18biQpe_ytWN3CBhA4IMq_v60qoap8u8s","https://drive.google.com/open?id=102FSdUIPjxT5wK8dNS3vK6ZcL2LN4XVl","https://drive.google.com/open?id=1qz1-7DylrxAnvaTskPpsCKVsV_PbUTBM","https://drive.google.com/open?id=1W4ULUIl_ZXwiMOGaHJGhlxNmyudqaoOR","https://drive.google.com/open?id=1rREXsCOWnHCcCODSHtbcxbcsjiUa24tI"};
    String[] ScienceLastYearPaper = {"https://drive.google.com/open?id=1qNt-T9fPKYHI1hXA6J2Pscgv4U2wknW6", "https://drive.google.com/open?id=1Izjc-Pk0JGmQk-tfiu4pPZiRyig1r1O6", "https://drive.google.com/open?id=1wLZQjZvzpG4cV_m4KJAtFniiHIG-rD4h", "https://drive.google.com/open?id=1r58wFX0AS8We9Da1fCMcB4stnJHXjy7f", "https://drive.google.com/open?id=17W5ZDXJM_NcKcCOSVa3NIb_0d5wlVWvs", "https://drive.google.com/open?id=1QsGr4Cwdl5cnVKrcGoE3sTMMip_Ma34w", "https://drive.google.com/open?id=16Bb55ilCbUKASHJF2fQd2m0tQ-FsWmQ-", "https://drive.google.com/open?id=18EGA-gI-vUi5Un4qc6w49PztNagkPWS4", "https://drive.google.com/open?id=1yqv0N9UDxKFLryYP4orOBoNOX5RnVazp", "https://drive.google.com/open?id=112E0T9-Q2xGrbpbNgiTtKnOam1jgUcVl", "https://drive.google.com/open?id=1GMU4q3NufeWJ4-ZF_ab73bntpidlvqbs", "https://drive.google.com/open?id=1S3O0ovt59vYsV1s0tpajpCnZIzIuwlwB", "https://drive.google.com/open?id=1BAgUjBh0XBExA7Kt-91RWA9MEkpg26KT", "https://drive.google.com/open?id=1gpjDWUhJVj4uX8pRZXK_6CFIR03-MlC8", "https://drive.google.com/open?id=1xdVs7-wixhz8Muvv13nXhL00_5-TN7b3", "https://drive.google.com/open?id=1ZpMzvvYl9wCPhr8i9mqFBFR-w913VBtx"};

    String[] ScienceLastYearSolution = {"https://drive.google.com/open?id=1ORlFXAHpUAcPmo0B8pNIOWPxENe0Qh9z", "https://drive.google.com/open?id=1S_KGQJxVbCMpEokj-52MooqNZIx6q70Y", "https://drive.google.com/open?id=1rmCgCjX0e6jC-Uqtxcm0vblNc3vrsFj-", "https://drive.google.com/open?id=1QNkj-gUZrM6q4vTNWSeyIr8H7gop9FlO", "https://drive.google.com/open?id=1CMreU-KZKH6UOJTGcyrCR_trV1X4bueC", "https://drive.google.com/open?id=1gKuD0Xb9X4oKQtjTcVpzCdUCs8TySmWX", "https://drive.google.com/open?id=1wHIBCJI4fIuwd9O8RLaFSaZxSZAXfpAI", "https://drive.google.com/open?id=1RgF-CFXrJS4JaXjVsyVZd7dzBtJaWHt2", "https://drive.google.com/open?id=1K5w-23yApSjbNYVj_vcCxoS36EFnnDX_", "https://drive.google.com/open?id=1uaRtB__pc6628B8eIjVy5Kf_9kyDZA_A", "https://drive.google.com/open?id=19hLKB1K2WDN648yVMINe5cZIbAKdQxG7", "https://drive.google.com/open?id=16KOpBGQuDEFWoW0DPZY4IP4ApwSj-2XN", "https://drive.google.com/open?id=1LFL7xoTk1wAkKlkN_JtjuyCa7DNw-7pD", "https://drive.google.com/open?id=1uDbiCj3ZLABAhMUzJXmZ9xdB7lkKTWIO", "https://drive.google.com/open?id=1ARZH4Q9sy7U9_sd_8Eol6iQAxpIZ27tJ", "https://drive.google.com/open?id=1ST6wzTky350gjIKF_NExqH_Mf2JBXwOV"};
    String[] ScienceNcertSolution = {"https://drive.google.com/open?id=1zz3rfyP_DBZUwMgi1NawQAkSsUGJH-mx", "https://drive.google.com/open?id=1H2HQOo0RviexSzOgRP8kyMV0-VjTvhxy", "https://drive.google.com/open?id=1DkUq4YdFXjJsbcQRAiEyjylKyGnzXQnG", "https://drive.google.com/open?id=16OQyW6bIog7vvyUUwp5kVD6nJ66h7Iyx", "https://drive.google.com/open?id=1Zf70Wfrt51y7FoxE72iJ4fhxAlqd6sRQ", "https://drive.google.com/open?id=1TonV8oB_D15ZTysdYGaSej8Szr9eZDYE", "https://drive.google.com/open?id=1-UkyKJK06BkTbcSOa7iIFa91a55ApRJo", "https://drive.google.com/open?id=1XswlSsb9PVjO-f3geTXyWm3Gwi0OT-FZ", "https://drive.google.com/open?id=1heHKeNDPDi6dJqQoW2cISYG3yNWxC7Od", "https://drive.google.com/open?id=1_Y0wrM4tyXuYyYyiaopwRWBFClUetet3", "https://drive.google.com/open?id=1xgWJGePTz0Qb4AOrHzUp3T7jq65yBuYb", "https://drive.google.com/open?id=1dRP1akP1kdJsEL2hYt1VQtj5KOrh04b3", "https://drive.google.com/open?id=1OUIaV77hgPHgGzfs82uft_ys1U_nBfsA", "https://drive.google.com/open?id=1_sSPI-cXCzAKBwv-uYvT8XJ7pZX-W84t", "https://drive.google.com/open?id=1wKBOcvGuAVR_1pk7A26dl5RJqwPygWva", "https://drive.google.com/open?id=1J2yMgaYeATxiVFApnqum4yR43WkwPaHj"};

    String[] ScienceNcertSolution_example = {"https://drive.google.com/open?id=1p3qXV4pIG7TJN638vjcqE3GVjNtY-l0P","https://drive.google.com/open?id=1artMGFYWBn1jZ-qZfLuXC_r1qQTHBX1m","https://drive.google.com/open?id=1UwXJ9zOSpuaj7oZqC_-0seziSL0pjreW","https://drive.google.com/open?id=1CpZbJgwmUoWQZr6Qhst7vBYMKWIO5Yq2","https://drive.google.com/open?id=1Sr4k3jtXSXqO23hPp6PZOCk36aaPPO-x","https://drive.google.com/open?id=1eGsEv_et4LQBgzT35WZ-MSBBHWZYvkYo","https://drive.google.com/open?id=1J24iNAbeZvpTJsrkum5fbIlaH-d5PuZs","https://drive.google.com/open?id=1uqnYS7tGxCzjZxC1PynHMJdFHOuKfWij","https://drive.google.com/open?id=1FXwEfDHf5vjL06KGmTMUMArAkLSw5-1d","https://drive.google.com/open?id=1iJdTufSIE2ygO0tOo3EbRFqiCrvpkJUk","https://drive.google.com/open?id=1DGi6EZP3qAeVarSPaS6OMKe9iBLa9lhv","https://drive.google.com/open?id=1d_BWn3C7s8VTzROklVLrWhlIoiWR651w","https://drive.google.com/open?id=1VXbkwrpsX3NN-Y1p35yQqB4HdTL0IcQw","https://drive.google.com/open?id=1mhlDUZBsqNppHeP3EhldC7gkCMkRRqvV","https://drive.google.com/open?id=1WmPxIVUgTJOokncpExQaRvREgbEPfnUV","https://drive.google.com/open?id=1T9_MZGF20KeCFF9nWtTplvz1ESwK0cEQ"};

    String[] sciiwmpo = {"https://drive.google.com/open?id=1CjgNs98M6KBd5u99jhPFNGH4-N-QNw_E","https://drive.google.com/open?id=1j-W0iuOIfQ_iHIdEfybmIPj9yjqn-vmg","https://drive.google.com/open?id=1SGAGx3osEPA2ajp4ic9vvR1zw05DaMqd","https://drive.google.com/open?id=1Q59LhB4yJNOhOX8ZthTxT3HRVECdo2br","https://drive.google.com/open?id=15Ehlap4O9a10FUebPd6sx4BELhREGNuZ","https://drive.google.com/open?id=1NHemPBLLdNPX8Q9r_1g6uBA6OLUiJRdg","https://drive.google.com/open?id=1zLbG79_9frGdN8xFWSZqfEATHZYsGb2q","https://drive.google.com/open?id=173KFtEzzpRmz5kqi2QqxU-6ILEJ06c5V","https://drive.google.com/open?id=1Ji-FU_4qnfbr3vHI-VjZWMLFYdZXwMHx","https://drive.google.com/open?id=1cR4WYqPPmgzHCoipcA1uNwrM2kz8MAWf","https://drive.google.com/open?id=1JCk1UXGv21O8tks1jaguZWBeOha03emH","https://drive.google.com/open?id=1UE2PzHB69WNdlCnyr5sOnsX154e_o4ML","https://drive.google.com/open?id=1rU21JomwJYd51WHnOePGHY6GUHI46VOG","https://drive.google.com/open?id=1DMr4c5lxnamhJCUUuK2HTauWbB-LZbmA","https://drive.google.com/open?id=1ZhEnrRlWZ6IMBdwITEr69DlzF3SiuoQK","https://drive.google.com/open?id=18FKEaFqwHAhA0g_QozFGwSZRT-h8ctPW"};

    String[] scirevision = {"https://drive.google.com/open?id=1eJD4_l9TUptoIgKSHZeaBWZp7apsGaXm","https://drive.google.com/open?id=1a6mWq6ze8_THI3RB8JGDCGl3qV1JNPSl","https://drive.google.com/open?id=15ejbAe96hwbynnAOtsHl4eLuiULk2zcX","https://drive.google.com/open?id=1M272VxB-sk_kWomagQ-DUkGKHeYriK3I","https://drive.google.com/open?id=1d9CdQcPyRXi1icI1oSUSpXVDGOYn94s9","https://drive.google.com/open?id=1GK5_-Wmk3RmmHkdv96EojHIbACs5DHD3","https://drive.google.com/open?id=1DDheTI5--B5Ci0Xn6ENoR-Np6K0iGreT","https://drive.google.com/open?id=1g0fnMMjiUIYvH3LudCE-0oG7d0UndUc5","https://drive.google.com/open?id=1EMSUxQr4m-mEQE0VO3FNBh6AtuJ3PdeE","https://drive.google.com/open?id=1N1-UhZpwoslEgJOAta3F98aZ1iKEzDWK","https://drive.google.com/open?id=17KSvjf_CNMNuZkXevNfaEkUBRV1uL0L5","https://drive.google.com/open?id=1-2Vf3trbz9vywrpYn3QmQNEO8IkYv-oy","https://drive.google.com/open?id=1o2OXr7ASW0neSF2_M5XqLq2Y9F-AHM85","https://drive.google.com/open?id=1JUgMZ0d216b4EShupiIMB24FWAygv-SF","https://drive.google.com/open?id=1hljSiZEJ4OAkdvTFdcLN_6cyFpsy1Eoh","https://drive.google.com/open?id=1JecAUahUPSj0pys_8alUcXYiWgXvN67r"};


    String[] sci_sample_paper = {"Sample_pape_1","Sample_pape_2","Sample_pape_3"};
    String[] sci_sample_paper_list = {"https://drive.google.com/open?id=18ezN0tPSmGccXLqreEqIZ1gH6th3ybGF","https://drive.google.com/open?id=1g1w6ds8VF9KyuHjPOQ8oRy0TsIZTBBRw","https://drive.google.com/open?id=19ArgVYPqQ3TKUs5b4ObRynXKo1zdHQn-"};

    String[] sci_sample_paper_list_sol = {"https://drive.google.com/open?id=1OqwbvF9kB63cFzmdTz_8b1zC8WVJWUmE","https://drive.google.com/open?id=1_JFMn9J9rZLKQzD7Nfv0TWhtgX5zzYGn","https://drive.google.com/open?id=1ZpaoE7-siPeu0-aieC1_yuwRVXuCkfj5"};


//social


    // CBSE SOCIAL SCIENCE
    String[] SocialScienceSyllabus = {"https://drive.google.com/open?id=1xKwVkAbQBCEmIMzs3pBafqGMcNVmD6ql"};


    String[] SocialScienceLastYearPaper = {"https://drive.google.com/open?id=1KPVwVLJ6Y7t80b7jHVmF79oZVZ2MxIFq", "https://drive.google.com/open?id=1SkPgLj2-DcK08y0DCOR9SlYKR3gZYibk", "https://drive.google.com/open?id=1WH0GkgpJAXydPWINE3IjpxWJXlAV2ZG2", "https://drive.google.com/open?id=1ymhUqbB5YiTFn7H8D4bk0iFwapmv3DmO", "https://drive.google.com/open?id=1I1YsPW7uNKFfWIhvN_6Zm1UQGsgKYYGu", "https://drive.google.com/open?id=19y1HrRwsRgOlxPnTdITb1H5ccwzArvXd", "https://drive.google.com/open?id=1eOEQngRvIkzrT6lbZQOP2UowFcVbhj95", "https://drive.google.com/open?id=17W92oimpu56gjW21dNeLqGCNzLWO1SF0", "https://drive.google.com/open?id=12lylOIjOx37H08hL4J1R3zdMYdp-jJOk", "https://drive.google.com/open?id=1otGMHMbbvsGvUQ9zL7gh-ZaeCi87_Ruh"};

    String[] SocialScienceLastYearPaperSolution = {"https://drive.google.com/open?id=1jVZjjjNe7uu6jT3VSY3qcFdhNgiuwRZQ", "https://drive.google.com/open?id=1Bto_9cjzYPoJ0j-wX3pmWxh2JzBDWtfV", "https://drive.google.com/open?id=1-dflqtV7Qrbe73YJ50CJ8DKYNCFXmaMH", "https://drive.google.com/open?id=1ku-nj9nwDvbWLdDn--fX1PglP8x-a6X0", "https://drive.google.com/open?id=1x3SV5-o61yntjhouRgheSgrxjF3KGjSJ", "https://drive.google.com/open?id=12P8lU7Im18vMms_FkQ4Quc9CsUn8hf6m", "https://drive.google.com/open?id=1O8VZovw3DODezrLuD8VtgdGut2XaCogg", "https://drive.google.com/open?id=10M8ry0zMc3t10Am0vfn5d1LnNJQmt02T", "https://drive.google.com/open?id=1kETOYkIWm16d5GT32RZ2bwIqcL1YN3tc", "https://drive.google.com/open?id=1_a6ChxzRQvcB7nKt1be49NxH3PqJXm92"};

    String[] SocialNotes = {"Political Science-Power Sharing", "Political Science-Federalism", "Political Science-Democracy and Diversity",
            "Political Science-Gender Religion and Caste", "Political Science-Popular struggles and Movements", "Political Science-Political Parties",
            "Political Science-Outcomes of Democracy", "Political Science-Challenges to Democracy", "History-The Rise of Nationalism in Europe",
            "History-The Nationalist Movement in Indo-China", "History-Nationalism in India", "History-The Making of a Global World",
            "History-The Age of Industrialisation", "History-Work Life and Leisure", "History-Print Culture and the Modern World", "History-Novels Society and History",
            "Geography-Resources and Development", "Geography-Forest and Wildlife Resources", "Geography-Water Resources", "Geography-Agriculture",
            "Geography-Minerals Energy Resources", "Geography-Manufacturing Industries", "Geography-Lifelines of National Economy", "Economics-Development",
            "Economics-Sectors of the Indian Economy", "Economics-Money and Credit", "Economics-Globalisation and the Indian Economy", "Economics-Consumer Rights"};
    String[] SocialBook = {"Eco Development",
            "Eco Sector of Indian Economy",
            "Eco Money and Credit",
            "Eco Globalisation of Indian Sector",
            "Eco Consumer Rights",
            "Geo Resources and development",
            "Geo forest and wildlife resources",
            "geo water resources",
            "geo agriculture",
            "geo minerals and energy resources",
            "geo manufacturing industries",
            "geo lifelines of national economy",
            "History the rise of nationalism in europe",
            "History the nationalist movement in indo china",
            "History nationalism in india",
            "History the making of a global world",
            "History the age of industrialisation",
            "History work life and leisure",
            "History print culture and the modern world",
            "History novels societyand history",
            "Pol science power sharing",
            "Pol science fedralism",
            "Pol science democracy and diversity",
            "Pol science gender religion caste",
            " Pol science popular struggle and movements",
            "Pol science political parties",
            "Pol science outcomes of democracy"};


    String[] SocialBook1 = {"Eco Development",
            "Eco Sector of Indian Economy",
            "Eco Money and Credit",
            "Eco Globalisation of Indian Sector",
            "Eco Consumer Rights",
            "Geo Resources and development",
            "Geo forest and wildlife resources",
            "geo water resources",
            "geo agriculture",
            "geo minerals and energy resources",
            "geo manufacturing industries",
            "geo lifelines of national economy",
            "History the rise of nationalism in europe",
            "History the nationalist movement in indo china",
            "History nationalism in india",
            "History the making of a global world",
            "History the age of industrialisation",
            "History work life and leisure",
            "History print culture and the modern world",
            "History novels societyand history",
            "Pol science power sharing",
            "Pol science fedralism",
            "Pol science democracy and diversity",
            "Pol science gender religion caste",
            " Pol science popular struggle and movements",
            "Pol science political parties",
            "Pol science outcomes of democracy",
            "Pol science challenge to democracy"};

    String[] SocialImp = {"HIS The Rise of Nationalism in Europe", "HIS The Nationalist Movement in Indo China", "HIS Nationalism in India", "HIS The Making of a Global World",
            "HIS The Age of Industrialisation", "HIS Work Life and Leisure", "HIS Print Culture and the Modern World", "HIS Novels Society and History",
            "GEO Resources and Development", "GEO Water Resources", "GEO Agriculture",
            "GEO Minerals and Energy Resources", "GEO Manufacturing Industries", "GEO Life Lines of National Economy", "POL Power sharing",
            "POL Federalism", "POL Democracy and Diversity", "POL Gender Religion and Caste", "POL Popular Struggles and Movements (project only)",
            "POL Political Parties", "POL Outcomes of Democracy", "POL Challenges to Democracy", "ECO The Story of Development", "ECO Sectors of the Indian Economy",
            "ECO Money and Credit", "ECO Globalisation", "ECO Consumer Awareness"};


    String[] social_revi_title = {"Eco Development",
            "Eco Sector of Indian Economy",
            "Eco Money and Credit",
            "Eco Globalisation of Indian Sector",
            "Eco Consumer awarness",
            "Geo Resources and development",
            "geo water resources",
            "geo agriculture",
            "geo minerals and energy resources",
            "geo manufacturing industries",
            "geo lifelines of national economy",
            "History the rise of nationalism in europe",
            "History nationalism in india",
            "History the making of a global world",
            "History the age of industrialisation",
            "History print culture and the modern world",
            "Pol science power sharing",
            "Pol science fedralism",
            "Pol science democracy and diversity",
            "Pol science gender religion caste",
            " Pol science popular struggle and movements",
            "Pol science political parties",
            "Pol science outcomes of democracy",
            "Pol science challenge to democracy"};

    String[] SocialSciencerevision = {"https://drive.google.com/open?id=1q27CLIEIpD01U8w4P8fIu44W__yrk6U-","https://drive.google.com/open?id=128aRThXDAUYNIesuMAOE3qzKK7uj3x3x","https://drive.google.com/open?id=1siWOyGsvCCyr4yYoNfwINq9N8c4UjsNq","https://drive.google.com/open?id=1cYgz2HxdEafAgzJfetA_hAd70D00ZYaK","https://drive.google.com/open?id=1I12MZwpegp1gcrjJXiQqvOjiwNfQOa07",
    "https://drive.google.com/open?id=1HCwM1J-M5fwazO7Px5KKbXrVSW7U6lFS","https://drive.google.com/open?id=1y9-dm8-8dDojH_o2PoI7ZVWCEauymOcE","https://drive.google.com/open?id=1fdsz6K1zgr-TkSF88gA-nc05CXFAGAvb","https://drive.google.com/open?id=1Z1qk2uBee1euhns0v0UKgI-QzIZHsPvX","https://drive.google.com/open?id=19zKBsJip--j_BLCAna0o-ZGuaAgHJwBa","https://drive.google.com/open?id=1yyPVmDlw1QxpRgHJSKGaRzxCzVKk-P0A",
    "https://drive.google.com/open?id=11xYiNmsLPXJHBprCDwD35bqvcvSNb-2m","https://drive.google.com/open?id=1VrJu2lBclqUBnnnDqHKY0wM_XTzczTpZ","https://drive.google.com/open?id=1xZtDX4oNygCl7auHPPFj7kW25w7PFBes","https://drive.google.com/open?id=11pJaLCXqM6vVwtUKOLzLZSO4vpM2dIHe","https://drive.google.com/open?id=1U0wWGEZOZym-CfTqY8HDzj-3wsi92vPN",
    "https://drive.google.com/open?id=19E67tFONtokEVCRDvjxGj7MbwRTSJAFy","https://drive.google.com/open?id=1MAFVckJGOGS2xXiifmcjJKTwMY93UCo9","https://drive.google.com/open?id=1eVRDHfaoqLHyW-Z4X9wXeaH3woApAkwr","https://drive.google.com/open?id=1X3-JLTrq-yVL2rmMiDXLXuKOk8c7JrIf","https://drive.google.com/open?id=1nBFJNWcembyMifWLuLUVk21XnR2TO2xI","https://drive.google.com/open?id=1dKpun8AKnnjVEduP1FUfL8a8S21j7EF3","https://drive.google.com/open?id=1W-M7i3pvl5jetQX5U0G2YHXcemD-90Ym","https://drive.google.com/open?id=1AVYSbDj1--MZON_SDWMhCdAwY5LwBmSP"};

    String[] soc_txt =   {"https://drive.google.com/open?id=1yVd7FQC1gyxLGvN6_YPVS8QGmhKLm6DB",
            "https://drive.google.com/open?id=1l_quzb3Sg6oVbKgDDm-xJ7fMXxRpM293",
            "https://drive.google.com/open?id=1GvrY1XGv2zsZQxfv_NRNvLhQugUQbSgy",
            "https://drive.google.com/open?id=1Azz8ELNFcppKG1JGZtOqY8HmXHDR1Uk7",
            "https://drive.google.com/open?id=1xuBJ0LfuLasUJkPA02dSMHsvv2KUvJNe",
            "https://drive.google.com/open?id=1FQXNVIYRtARNaveQWr_JEMxCoWt5Upoa",
            "https://drive.google.com/open?id=13MzI6mWtXPh5sOkl-OBdJaGrHH8VPFed",
            "https://drive.google.com/open?id=1D4pSLGQ5bM5wzTo8HyASorNzKwxeu71r",
            "https://drive.google.com/open?id=1nnb58Segdy85kNZ1_PM7NA7hNZZVak8R",
            "https://drive.google.com/open?id=1ByTM8TC_f3iH3V63JQ2Wqf0b0dKZQNIt",
            "https://drive.google.com/open?id=1WHPjo10p3UUTnQ7Dxx0bgum3tteHPw7q",
            "https://drive.google.com/open?id=1608kaoABH8SmU0XJU9SEEYfw-o4BQVGZ",
            "https://drive.google.com/open?id=12V_DnpTC1OaRH4TRdiO_nDjYI18Xpn6k",
            "https://drive.google.com/open?id=1Qcga6t9znkURFo8hEhNSS3ean9elPEQ_",
            "https://drive.google.com/open?id=1ZEfXT8EQsmplOPCjD4L-EsivRGzumKNE",
            "https://drive.google.com/open?id=1hhUqWzxZ2JeApbPQYUNTGC2XcZPeeoJM",
            "https://drive.google.com/open?id=156224-iJPnd_m4AYOvZNjzlCafmznOWz",
            "https://drive.google.com/open?id=1wgdEJi6WQuMo0HI03BO_eIC4La-C8MHp",
            "https://drive.google.com/open?id=1VL6Le1tx4MfBPuubegjabxGM90v_NnB-",
            "https://drive.google.com/open?id=1BCHwkEIWiQVSFNl9j9dqw8Z3gfMI_8pr",
            "https://drive.google.com/open?id=1gYqUTgQWCAgDVYRJ8Qr4QWzAddXtJdXI",
            "https://drive.google.com/open?id=1HgQZWGzlHI-vBwb8zEwJQ5OjHfAPbnQD",
            "https://drive.google.com/open?id=1AOUIDB3v785I0oaaV5E_Ohxf9pDjhgzF",
            "https://drive.google.com/open?id=1EUET2q3j2px3SdppBt2iH8m15fqSVvCB",
            "https://drive.google.com/open?id=1touDsE9ltL0hceRJPL-ANoToPxWBfE01",
            "https://drive.google.com/open?id=1wK1i2m2fMI8v-Hvdmgy_9Xhpa6vW_2ce",
            "https://drive.google.com/open?id=1ZP_J_6h5JYfp0LuJbedZNqMAOoPudgD9"};

    String[] SocialSciencencertsolution = {"https://drive.google.com/open?id=1H0MW-ziaaH_C42lMeVMdciWhnm9kM7nX","https://drive.google.com/open?id=1bhTf5o9IR9cro11mpBTvuObzL0kegbbu","https://drive.google.com/open?id=1JWzzrRNS0f6D2U2egJ7GbPkDf8E7PQwz","https://drive.google.com/open?id=1OiczaKC8djR5qvjJxyr_sjQmB8bgRQ2w","https://drive.google.com/open?id=11PL5GT4Zy7wU0WUUSn2KVa9FWmqQb6lu","https://drive.google.com/open?id=15nCjaUrqvyHzbgDiAfWVZczwXM1DszDS","https://drive.google.com/open?id=1ZuevaQX4t9KQ29Acx_YElv_z0fuhsGQu","https://drive.google.com/open?id=1QPrzJtNFc-IQB7FcGGOJuwixyz3bZkhp","https://drive.google.com/open?id=17NM3uJA36jB_gqWCSCqhZuJp25JwAUDZ","https://drive.google.com/open?id=1lVruV9Pb5_OC1iQBHkJS3FWVTbJto-c0","https://drive.google.com/open?id=1uEDQgjg4qj73PdE11TatVTYd_YGwANuw","https://drive.google.com/open?id=1g7rMrlBEkI1NvKqrFWd6EOAL3hQazy8j","https://drive.google.com/open?id=11J1dyGuJv-LIa5FQiuOB_xhK1wv6RU67","https://drive.google.com/open?id=1Q0hF9c5LF74uysasaraPYjkhOj5k5Rgr","https://drive.google.com/open?id=1s8MOgBY94JnVxCGJKK_jvT--w6cg_NPy","https://drive.google.com/open?id=1vycCJLCsF0qulc_S9uZZvNR7nSSftaqe","https://drive.google.com/open?id=1l_kW8HXlrRZrbWKK6x8t5SkGcs1BG9rR","https://drive.google.com/open?id=1Jl3A31qq8Fj_nA-DrcROsJUQOeEtwx5u","https://drive.google.com/open?id=1eACjtm7c4soIB8QlycYGpgcIZYz8lpFr","https://drive.google.com/open?id=1wQAI9FQaGS9vgUDmCSUN_BMsX6DF-lMP","https://drive.google.com/open?id=1zqb1Nq1MgGmaAcJFK2X6pwteAh4n-w6C","https://drive.google.com/open?id=1_jjLKX2WfTZ8V-akVH8slYLe1FBuhsM5","https://drive.google.com/open?id=1aDZRt5_rC6Lg7NqQMTYD2RwNKziWRlwM","https://drive.google.com/open?id=1JEO9tHSpF23IEpPoKB87TUrdA-2d6mpr","https://drive.google.com/open?id=1JXvIaq9EbhLZpUBG2za3se5mjMM1YroS","https://drive.google.com/open?id=1G8bO5Fq0_5O212vqc9GXe2aAMpeNllc0","https://drive.google.com/open?id=12mbJVuB4b88sCNXrXEr_uUCulbmBbm2P"};

    public String[] sample_paper_social = {"sample paper 1 with solution","sample paper 2 with solution","sample paper 3 with solution"};


    public String[] sample_paper_social_science_list = {"https://drive.google.com/open?id=1CCCgXKskNbE835-az3VFoy85GqnPJmmB","https://drive.google.com/open?id=1QfEvyG5BkI89how9TjTP1VGy_1GEUaTj","https://drive.google.com/open?id=1d114YJ1fLG40DBGsmYfXlNaTdz6y0Hn8"};
    public String[] sample_paper_social_science_list_sol = {"https://drive.google.com/open?id=1rkAX8lQBAEorcMX4ejSBW9cdP7_hNk54","https://drive.google.com/open?id=1F7LI4XON8rN9c-QqB4K_xx0QCL4CRiqD","https://drive.google.com/open?id=1Kq4PU7jMEc_o7mXzB6BX4woJATu3GHB_"};


    //english_commucative

    //CBSE English COMMUNITY
    String[] EnglishComunitySyllabus = {"https://drive.google.com/open?id=1fqEpXgSMUjvjAwtVUYiUn9f7bbpeJmtB"};

    String[] EnglishaNotes_dubli = {"Fiction-Two Gentalmen of verona", "Fiction-Mrs. Packletide's Tiger", "Fiction-The Letter",
            "Fiction-A Shady Plot", "Fiction-Patol Babu,Film Star", "Fiction-Virtually True", "Drama-The Dear Departed",
            "Drama-Julius Caesar", "Poem-The Frog and The Nightingale", "Poem-Mirror", "Poem-Not Marble,Nor the Glided Monuments",
            "Poem-Ozymandias", "Poem-The Rime of the Ancient Mariner", "Poem-Snake","Grammer","Reading","Writing"};

    String[] EnglishaNotes_sol= {"https://drive.google.com/open?id=1yuWeM4sfYD9p-ourvcyihxD58uLO-LNB","https://drive.google.com/open?id=1rtabAXA2H1hum2apscj_xJdwdT3SWLWU","https://drive.google.com/open?id=1EEJksq1733df455M4m2p9lKMR18MvRG2","https://drive.google.com/open?id=1xhOLKUN3frUY3yVR78pmRBqo0h7MQ0X3","https://drive.google.com/open?id=1xFeMKfVrbka3462pkws4ox6OZXk7r7wz","https://drive.google.com/open?id=11TJG__miDPiWOvdiT0X1lyGVArokJalQ","https://drive.google.com/open?id=1c5RYNcQRBoQkIxUsY32yx21s9wUcjD4X","https://drive.google.com/open?id=159B9qQYlxBj_3V5-yptcSMbfVS53mmNA","https://drive.google.com/open?id=1l8q2hhRvhkIFudNQ262YscmCs9_AZquq","https://drive.google.com/open?id=1cMLpinNAQhten_OpkB0JAHkj9Bmmi8Q_","https://drive.google.com/open?id=1k5Aj5FWzsO_UZCFlSAczylD0SMrOStN7","https://drive.google.com/open?id=1oGLIMo-NXfvs7p8bebI-JPU7vPVdFEJu","https://drive.google.com/open?id=18H1cnRmcFEaP70z79dX9ynw0B11rMJpb","https://drive.google.com/open?id=1OeGf-odtp5SrlMXAnnt08LAHg9MosN8E","https://drive.google.com/open?id=1nIX89YHnQopz2tPbej188VuouEUeF-zm","https://drive.google.com/open?id=1WbbudmW6HL8MePfbim1i4TtxlHJTAHSH","https://drive.google.com/open?id=1OJNUkHSsOmRxbzdrj8qpyNzAYAg-DWPk"};

    String[] EnglishComunityLastYearPaper = {"https://drive.google.com/open?id=1qkf2T4P1iFb6tp9I8mbFauAYg_cjyzz2", "https://drive.google.com/open?id=1eJjh5IKaP3mftQoQDwCZimnxTqLSINOL", "https://drive.google.com/open?id=1_7F6EUMx7PGOc-m_3CVetgg6LFZkrsZY", "https://drive.google.com/open?id=1XgT1d6S9NwrL-q51WuYnRms_M038owDu", "https://drive.google.com/open?id=1TqI4PuNsulcvgBhUWn3doNvd-Mn9UlAf", "https://drive.google.com/open?id=12S8fpjDqVl1Y-fSmnkMTMJba1Ou8jyG1", "https://drive.google.com/open?id=1qkf1HrYEnD-NvHC-0ST3HsOymBIX4yyI", "https://drive.google.com/open?id=17sqnLK3jaB6bQO5tN10eUmtB7GpgiN1C","https://drive.google.com/open?id=1vpQKpP8I2wpNZyWrmP4bsvVWm9BQwWfK"};

    String[] EnglishComunityLastYearPaperSolution = {"https://drive.google.com/open?id=1GLaFZOyyr1F8Ep49XOHXhiuFfa_qbY6r", "https://drive.google.com/open?id=1FDuxbwkD_N_R1bp6vbn5d4YA7f4r-s5q", "https://drive.google.com/open?id=17tlKTbjAKTdiFbX_F6MsYyDHkTQ0vR08", "https://drive.google.com/open?id=1XI9plnc7TwzQ1TruUyJ-igchbr4uy0cK", "https://drive.google.com/open?id=1B2yHwONjNPE5ucYF5aNO_wC9mNOnpfGF", "https://drive.google.com/open?id=1otNzKL5EJ-2G1k-eizxA1p6lqRCrk8JP", "https://drive.google.com/open?id=15ASx5Rn-z7mTvnncYp-fN_wj4ykFoVkQ", "https://drive.google.com/open?id=1ciRiUYYJkKnDs1zAcJSrxjm4mtIEXBtB"};

    public String[] sample_paper_englishA = {"sample paper 1 with solution","sample paper 2 with solution","sample paper 3 with solution"};

    String[] Englishasample_list = {"https://drive.google.com/open?id=1WuRbjjczetjkqmYHqtBHMxbjMGHjxZYy","https://drive.google.com/open?id=1WBIjgZE04E_U88_sr8B6daZzGgqKRzpe","https://drive.google.com/open?id=11nJLyyIeuwYHmFm8V3txSO00aAegFhQu"};
    String[] Englishasample_list_sol = {"https://drive.google.com/open?id=10BvxcoLOSQC2vQsrTD_YUBiKSboZC8zE","https://drive.google.com/open?id=1flv00vLM_gb2pKmlosBuUZJxEZbqsl-d","https://drive.google.com/open?id=1ZVl0OQqM85C_5ipAt-Scys6ldlWkGdBm"};




    String[] eng_txt = {"https://drive.google.com/open?id=1hKLQ-89qvFPTQYsJQG3FxhGjPu4p7YQ5",
            "https://drive.google.com/open?id=1cxqH7kP8xaub30V_mff8FWXavxTT7Eec",
            "https://drive.google.com/open?id=1gbQS5Llg3EIHPhhYjXAQopourtA0Is2o",
            "https://drive.google.com/open?id=1c7xDxmut8AEXMqqbNdd3cBvMxLh9-0vl",
            "https://drive.google.com/open?id=1X5L4zHL944XjhjHxDzjjNAw9U5x5fGUb",
            "https://drive.google.com/open?id=1Oe5X-_kaoYdaQqS-S7sc5I1YsCld73wR",
            "https://drive.google.com/open?id=1HBYWM48fN3NG6KNViBvsI1TV7fdYCWca",
            "https://drive.google.com/open?id=16M62aJv0QqaBIbBfjFl4xcs7kbIzfnJW",
            "https://drive.google.com/open?id=1miaPz6Vmoz1NYExTNJwM8nDK7X6UobiF",
            "https://drive.google.com/open?id=1QsM9TYxZCeBrJ8Yx78I8FFKLc44tG2j3",
            "https://drive.google.com/open?id=1bMfYtcZZQ_sWpXzzSdaYZuAMovqtUDtf",
            "https://drive.google.com/open?id=1cm-ntuE4XBBmnbGfNalF5mccXHeisvJJ",
            "https://drive.google.com/open?id=1W_h1ZtCkiOowB9-ZRkt9BTx6Sa1AYOeg",
            "https://drive.google.com/open?id=1HPWoZR_6bk2Ku9G8YhV154KnbKsgZT0q",
            "https://drive.google.com/open?id=1CWHlBj4jgr1cwkkXiL2pCnUOudpFLlUX",
            "https://drive.google.com/open?id=1D99seEd-ojMLKQ5fGn80KxV3qw-ZlNnY",
            "https://drive.google.com/open?id=1bE4U2xAemEmDbQ5wenZbYNsgtd3lCAYY",
            "https://drive.google.com/open?id=1FcrhwYj5_EWIDOBt8f5DGZPmw93wUJAP",
            "https://drive.google.com/open?id=1VBqSmXcV-BOMCVuNBvmebOLxCaLkIMLE",
            "https://drive.google.com/open?id=1ciJIyFVZ46URqhUxsIXgaiE2RAf9ppNS",
            "https://drive.google.com/open?id=1mdTS3pNE1wb4eT42iRBaETbDfGibtdXk"};

    String[] EnglishbBook = {"Footprints ch01 A Triumph of Surgery",
            "Footprints ch02 The Thiefs Story",
            "Footprints ch03 The Midnight Visitor",
            "Footprints ch04 A Question of Trust",
            "Footprints ch05 Footprints without Feet",
            "Footprints ch06 The Making of a Scientist",
            "Footprints ch07 The Necklace",
            "Footprints ch08 The Hack Driver",
            "Footprints ch09 Bholi",
            "Footprints ch10 The Book That Saved the Earth",
            "First Flight ch01 A Letter to God",
            "First Flight ch02 Long Walk to Freedom",
            "First Flight ch03 Two Stories about Flying",
            "First Flight ch04 From the Diary of Anne Frank",
            "First Flight ch05 The Hundred Dresses I",
            "First Flight ch06 The Hundred Dresses II",
            "First Flight ch07 Glimpses of India",
            "First Flight ch08 Mijbil the Otter",
            "First Flight ch09 Madam Rides the Bus",
            "First Flight ch10 The Sermon at Benares",
            "First Flight ch11 The Proposal",
            "First Flight Poem ch01 Dust of snow",
            "First Flight Poem ch02 Fire and Ice",
            " First Flight Poem ch03 A Tiger in the Zoo",
            "First Flight Poem ch04 How to Tell Wild Animals",
            "First Flight Poem ch05 The Ball Poem",
            "First Flight Poem ch06 Amanda",
            "First Flight Poem ch07 Animals",
            "First Flight Poem ch08 The Trees",
            "First Flight Poem ch09 Fog",
            "First Flight Poem ch10 The Tale of Custard the Dragon",
            "First Flight Poem ch11 For Anne Gregory"};

    String[] Englishbtextbookff = {"Footprints ch01 A Triumph of Surgery",
            "Footprints ch02 The Thiefs Story",
            "Footprints ch03 The Midnight Visitor",
            "Footprints ch04 A Question of Trust",
            "Footprints ch05 Footprints without Feet",
            "Footprints ch06 The Making of a Scientist",
            "Footprints ch07 The Necklace",
            "Footprints ch08 The Hack Driver",
            "Footprints ch09 Bholi",
            "Footprints ch10 The Book That Saved the Earth",
            "First Flight ch01 A Letter to God",
            "First Flight ch02 Long Walk to Freedom",
            "First Flight ch03 Two Stories about Flying",
            "First Flight ch04 From the Diary of Anne Frank",
            "First Flight ch05 The Hundred Dresses I",
            "First Flight ch06 The Hundred Dresses II",
            "First Flight ch07 Glimpses of India",
            "First Flight ch08 Mijbil the Otter",
            "First Flight ch09 Madam Rides the Bus",
            "First Flight ch10 The Sermon at Benares",
            "First Flight ch11 The Proposal"};

    String[] EnglishbBook_new_ncert_sol = {"https://drive.google.com/open?id=1z_XPu__8ztfeUJ8YhTb0b_Nq0vR_nrhd",
            "https://drive.google.com/open?id=1hmtyQRirjzj5VOMizKpErKjflHQxpnV4",
            "https://drive.google.com/open?id=1d-AZ2twiLqwcJo5DDq3EDhKoB15Py0uL",
            "https://drive.google.com/open?id=1EM14qtU7e3tYaF7rQyCgKqy5WdIy0gN-",
            "https://drive.google.com/open?id=1f7g19N3kK5KK62omgwvSRcYepVOVDz0K",
            "https://drive.google.com/open?id=1XIE1uxxnONIOBH7zgjQoMWyoHMkmmR-g",
            "https://drive.google.com/open?id=13Er4ViomPVimwaf6ulzSULlT6joGRqfZ",
            "https://drive.google.com/open?id=1l_iwlYW-ttsW8T1MZNkQ-T9WRt3arlyD",
            "https://drive.google.com/open?id=1SmTk6attYV070CM56cuXz7DjJAckWA7n",
            "https://drive.google.com/open?id=1BNogU5ymA8R1Fc7QdRG778P-Z1AGCI5g",
            "https://drive.google.com/open?id=1pcr8vC3mG2AoMFyXSjry6jFHxntyQo0V",
            "https://drive.google.com/open?id=1wBKR9DD63zVAJY84FPC4_gZf6Ua6XYCw",
            "https://drive.google.com/open?id=1IdlkkbnOEJcYTioWy-jUImhvq9z5Gsxs",
            "https://drive.google.com/open?id=1aeOznyvC6rFtZDy-DJdXa7OQndbFNP7V",
            "https://drive.google.com/open?id=1R08R0cbZf8ME4aX5L1v5TY_m9Zs2JZr3",
            "https://drive.google.com/open?id=1t2U2mqEPwHxXYIvfeIPaApWFK_asgO5l",
            "https://drive.google.com/open?id=172CobjXp44XI1lp31V5lBbNSqfvmk5EE",
            "https://drive.google.com/open?id=1wQ3GYfQG-sVHP3QciA2VkYQPZTFMVoKD",
            "https://drive.google.com/open?id=1rtQm3E0C1kHwFg2jHhBpZOTrhXrGsyIb",
            "https://drive.google.com/open?id=1Ys4Vw17-TmAI2tlIseYkLGXuG4IbCE4L",
            "https://drive.google.com/open?id=1KuPrGFqiBGVQM8vYqQ4o07OkwXUQAmyu",
            "https://drive.google.com/open?id=1FVTcQNHFzDmI5sveUp-ZlB2StSem6xyi",
            "https://drive.google.com/open?id=1WpByiphoLeA_cvL1BNUM6PEaSDtOoKb2",
            "https://drive.google.com/open?id=1y5ypkSz1jhEottdtwTa0SvO5ub_JQUDu",
            "https://drive.google.com/open?id=1aArMpLIxIWLfQUmXhTd4kozF3VOoWz_j",
            "https://drive.google.com/open?id=1z8vz354NIDol860hqELnHzAbxJuq0aCH",
            "https://drive.google.com/open?id=1tSn0yKb1rMa7NF9hDcuyaDoAc8re5ukD",
            "https://drive.google.com/open?id=19ox6iiT2qRjq2khz5_6ldwt-J-iX8qQ9",
            "https://drive.google.com/open?id=1wopTnVkD9x8xWaqe5J9q67PL05Is0vfI",
            "https://drive.google.com/open?id=1_rU68fQaLf51YXx9EmjY1tNtncCWWRBF",
            "https://drive.google.com/open?id=1Ys4Vw17-TmAI2tlIseYkLGXuG4IbCE4L",
            "https://drive.google.com/open?id=1KuPrGFqiBGVQM8vYqQ4o07OkwXUQAmyu"};



    public String[] sample_paper_englishB = {"sample paper 1 with solution","sample paper 2 with solution","sample paper 3 with solution"};

    public String[] sample_paper_englishB_list = {"https://drive.google.com/open?id=1QNEVxt4U6z4a7hQ-k7L8pyQvBaUfm-Us","https://drive.google.com/open?id=1xDWCIMwdTOi3hdJDaFha74aTBnEbMpjc","https://drive.google.com/open?id=1_XDBQTGOcvHkb8fSaNSKj5HduiO1GYg8"};
    public String[] sample_paper_englishB_list_sol = {"https://drive.google.com/open?id=1Trz94GESHXs2L68mAzeelz4o06SmzZ-L","https://drive.google.com/open?id=1-dXZFlVhutkl7pBa9tfioBvHDYStizyT","https://drive.google.com/open?id=1RtcWCPnRz0-Db5AbxNo20ud_j9LlOPXc"};
    String[] EnglishLanguageLastYearPaper = {"https://drive.google.com/open?id=1qWGcaCZs3dVdoJsUXljb_KFkW9ll4ek4", "https://drive.google.com/open?id=1E1hi-tQMtRrLJnFH--huMDL5UR0MQE7T", "https://drive.google.com/open?id=1In3lp-pPCN_hExTzcDfvAxAJkZ7FGYMC", "https://drive.google.com/open?id=1uEqUkgtpOwm3W3hiLKE4Lvgy3y4Tl1NB","https://drive.google.com/open?id=1r714dy1asKE4IphoQMHidn8b0TEZ6Lah"};

    String[] EnglishLanguageLastYearPaperSolution = {"https://drive.google.com/open?id=1No6fvTyPZgjSCnJ7hs2zTaNi-YbeshY-", "https://drive.google.com/open?id=1Cf_FfZhJbz3d6iQ-a5Bmu-TQesxoiqK6", "https://drive.google.com/open?id=12ZE9pLmqJUQNwcyRtlPbW6SKIyTCHXAn", "https://drive.google.com/open?id=1iy_JCQEtzy9OL96PF9YG85fbQxRy8Uck"};


    //hindi_A


    String[] HindiaBook = {"Kr Ch01 Mata ka Aanchal",
            "Kr Ch02 George Pancham Ki Naak",
            "Kr Ch03 Sana Sana Hath Dodi",
            "Kr Ch04 Ehi Thaiyan Jhulani Herani ho Rama",
            "Kr Ch05 Main Kyon Likhata hun",
            "Ks Ch01 Surdas",
            "Ks Ch02 Tulsidas",
            "Ks Ch03 Dev",
            "Ks Ch04 Jai Shankar Parsad",
            "Ks Ch05 Suryakant Tripathi Utsah",
            "Ks Ch06 Nagarjuna Yeh Danturit Muskan",
            "Ks Ch07 Girija Kumar Mathur",
            "Ks Ch08 Rituraj",
            "Ks Ch09 Manglesh Dabral",
            "Ks Ch10 Svayan Prakash",
            "Ks Ch11 Rambriksh Benipuri",
            "Ks Ch12 Yashpal",
            "Ks Ch13 Sarveshwar Dayal Saxena",
            "Ks Ch14 Manu Bhandari",
            "Ks Ch15 Mahavir Prasad Dwivedi",
            "Ks Ch16 Yatindra Mishra",
            "Ks Ch17 Bhadant Anand Kausalyan"};

    String[] hindiA_new_ncert_sol = {"https://drive.google.com/open?id=1wyq6eEzVkqItzqjdINa4nHR9DXTCM-lc","https://drive.google.com/open?id=1D5vSD0vAItV1SlptNz1U_wV0NC1jlTmG","https://drive.google.com/open?id=1Gmmh5RuAPeJZVPYJwscXCpSBb9lkyn7x","https://drive.google.com/open?id=1I1phL7mCyUCfpodw9Dr5FKXEyRwbB1tQ","https://drive.google.com/open?id=1KrOW8ZYqGliX7Cum2tZ64AKGKCp1RKTm",
            "https://drive.google.com/open?id=1OeYSHeBHmTstRZ3_KwC_-VPvybtOLn6h","https://drive.google.com/open?id=1NCzQJLbrT-XHj8uzCl0jRlxSRZRLRhTb","https://drive.google.com/open?id=1hLrWTuachnArLepEV5nmybzRb7mriX-J","https://drive.google.com/open?id=1Ym5ml7hpN-xEbRsJSwhmUSh_Cy0drTxr","https://drive.google.com/open?id=1HKjVS2JcQz4tfgV6anJ3eEqVZSd_2EUB","https://drive.google.com/open?id=1pTK75s6kYwquF_2hRy7DyCKZrAI11kz1","https://drive.google.com/open?id=1cKXonVn2prWSq6cEwvHj0btlOk9NpWcZ","https://drive.google.com/open?id=1FW4RTqjK0xylJM7zsN-mLqQujOQF90Nr","https://drive.google.com/open?id=1r6TpW2mO7Vz48TCIh9ut6Zx3VgRSgKBt","https://drive.google.com/open?id=1z1vcnAuf04R3xKXTjeJ8HltxhoAyoLBZ","https://drive.google.com/open?id=1weRJfgVoh3niGOUPjQblbKOlJWVj66NM","https://drive.google.com/open?id=1LQ7ZYabPNLo4ZNwdA58aaEMlgYx_s6cx","https://drive.google.com/open?id=1oNZGD76ugxwTs4ZTERoDXkpnHiSPqMu0","https://drive.google.com/open?id=1E5LQuBJJOT7tewSXSLqTfA6mxTz3n2VJ","https://drive.google.com/open?id=1iKEYUkVmn4C1-hIEPr94EvZNwi9HKCso","https://drive.google.com/open?id=1ZKZgW-71v7wLxeaDIqgPucHZ8IPl2gdG","https://drive.google.com/open?id=1FWYuQVC_DREpzKN6A2EzFljsJ4Wn6QYN"};

    String[] HindibBook = {"संचयन पाठ-01 हरिहर काका",
            "संचयन पाठ-02 सपनों के – से दिन",
            "संचयन पाठ-03 टोपी शुक्ला",
            "स्पर्श पाठ-01 कबीर [कविता]",
            "स्पर्श पाठ-02 मीरा [कविता]",
            "स्पर्श पाठ-03 बिहारी [कविता]",
            "स्पर्श पाठ-04 मैथिलीशरण गुप्त [कविता]",
            " स्पर्श पाठ-05 सुमित्रानंदन पंत [कविता]",
            "स्पर्श पाठ-06 महादेवी वर्मा [कविता]",
            "स्पर्श पाठ-07 वीरेन डंगवाल [कविता]",
            " ्पर्श पाठ-08 कैफ़ी आजमी [कविता]",
            "स्पर्श पाठ-09 प्रेमचंद",
            "स्पर्श पाठ-10 सीताराम सेकसरिया",
            "स्पर्श पाठ-11 लीलाधर मंडलोई",
            "स्पर्श पाठ-12 प्रहलाद अग्रवाल",
            "स्पर्श पाठ-13 अंतोन चेखव",
            "स्पर्श पाठ-14 निदा फ़ाज़ली",
            "स्पर्श पाठ-15 रवींद्र केलेवर",
            "स्पर्श पाठ-16 हबीब तनवीर",
            "स्पर्श पाठ-17 रवींद्रनाथ ठाकुर [कविता]"};



    String[] hindiB_new_ncert_sol = {"https://drive.google.com/open?id=1AAz3BSB42jdwwQRZ5zxxbG0ZZbKKfkcA",
            "https://drive.google.com/open?id=1ydLT2VoKDblfen77uuZCJT1sU_AW5Oyk",
            "https://drive.google.com/open?id=1oSP6dc3WmvL0p8moCqY7Ji3T4XVeZDSR",
            "https://drive.google.com/open?id=1HMAUnTTxbJ59ln6iDCCR3hrnu1Uv0j7W",
            "https://drive.google.com/open?id=1piZKjKR6cOdP-1Q6qUiGHrXnoxnP9u0a",
            "https://drive.google.com/open?id=1uz0gg5ySeh9Nk_E8DRSKFochvA0kk-QB",
            "https://drive.google.com/open?id=1SBqOJggr1vif0_cpGTF9XGJ9wh--cn5r",
            "https://drive.google.com/open?id=1GiCf70mvjAc5Wc75xxnC08_dSk55ZKn3",
            "https://drive.google.com/open?id=1lQ8pAOCvC9mDJn1hyKcrohwnA_9nacxa",
            "https://drive.google.com/open?id=1cJ6rx9Vyk9zl7eNL4UoMcRGoaDJ_x9YP",
            "https://drive.google.com/open?id=14cJXg81tUroD3pJIImyX9LttkB_FKZgD",
            "https://drive.google.com/open?id=1GjCtbStxyclDkgY2GK2Z2TWB2avWk-D1",
            "https://drive.google.com/open?id=1Ye2wFvnCGZ28brNfMmRBwG1NYyAYZ1CX",
            "https://drive.google.com/open?id=1AGDVIwdxx_VGuNPe8xjTWshbivTAoFmw",
            "https://drive.google.com/open?id=1BryRkFhlVQTsJzEyeosAgpLQXPziwEER",
            "https://drive.google.com/open?id=11ECA2IgwRXrbclDZ6rJb4138KjUoZDsr",
            "https://drive.google.com/open?id=1tdNN2nqL4izCOBz53dG01VjlBqLT-i9t",
            "https://drive.google.com/open?id=1l4RP9bc6IdOYl0LZhNVdA80BXj0Modju",
            "https://drive.google.com/open?id=1LK3NSs3PMJbZ2LwmoMILfG7z5eRjkvSD",
            "https://drive.google.com/open?id=1AzPKekQX5kwYFFn1EDDdlPe4rdC62sq6"};
    String[] HindiALastYearPaper = {"https://drive.google.com/open?id=1L3-Be0n_FvWyGqwN2Hm8iqRL03zlTSXW", "https://drive.google.com/open?id=1STyUbd2t7RiYvtgMtGRIvt0a6PHKak8D", "https://drive.google.com/open?id=1Lmd6qp-NEKZJvdl6srO1yiRjZlaZHSod", "https://drive.google.com/open?id=1tohNdydz4GJmrEKZZJu6FKu1kr8jo-xA","https://drive.google.com/open?id=1DvvOB0AdAUHEBb28gCQrTZOtQRtV9fYE"};

    String[] HindiALastYearPaperSolution = {"https://drive.google.com/open?id=1os6A9givL8nffPwRkOrx5prtaUEUWPpS", "https://drive.google.com/open?id=1YhLeYeFHJewZl5EZ7IWxTOa-9bEhym8f", "https://drive.google.com/open?id=1iWpdbMZh2xV1E5vI_r_Bzx_aEG2GZs0-", "https://drive.google.com/open?id=1pHWHLXynaAViLGSh_zXCGt8cneVAvaCJ"};
    String[] HindiBLastYearPaper = {"https://drive.google.com/open?id=1Z0t-KzzdNS0_PcgkT4DszkMzzvk5Tzr2", "https://drive.google.com/open?id=1x9i0MGOgAb1mv8TduoBgmMWBtJD8GUVH", "https://drive.google.com/open?id=1eKNlvV7In4Pmmz1-d62TKMyCT-AKzhGA", "https://drive.google.com/open?id=16AaQdLpXn8w6-ilvAKadel-6ecpUGgTJ", "https://drive.google.com/open?id=1p_xUpGlfJvHmqcXr2WuBnKTIDgE6_JpR", "https://drive.google.com/open?id=1pa3BnY3n3I5dsDs8Nhi6RyM9xAq9KWEf", "https://drive.google.com/open?id=1mzIBInvBuRaii55NazOJQFyv8xjkSYRZ","https://drive.google.com/open?id=1cK1j_GL_dposlvmFWKOiFRt1gX3jNDpj"};

    String[] HindiBLastYearPaperSolution = {"https://drive.google.com/open?id=1it2tTwh9Bfi9G3P-IuwL_bUS_gmYiXTo", "https://drive.google.com/open?id=1PHZgYA-UBrZii-Xm9MOlaY86UF0y6IaJ", "https://drive.google.com/open?id=1QswetQRutGwfW22v87bSNjDMLMleXaOd", "https://drive.google.com/open?id=1XbgNwh7TMf3HjZJhuhFBlfLbnQgFsgca", "https://drive.google.com/open?id=1za6F6IXzSLeeEkrkj7dpaXTsuE-gB4ez", "https://drive.google.com/open?id=1_0jZ2Xho4clmIzce-CfhAod9O0FyIp8T", "https://drive.google.com/open?id=1Wa8KE8d0z1eAUNZDRPLELskuPf2VEPH1"};


    //english



    String[] EnglishAPapers = {"CBSE 2012 English Communicative Question Paper With Solution Set-1",
            "CBSE 2012 English Communicative Question Paper With Solution Set-2",
            "CBSE 2012 English Communicative Question Paper With Solution Set-3",
            "CBSE 2013 English Communicative Question Paper With Solution",
            "CBSE 2014 English Communicative Question Paper With Solution",
            "CBSE 2015 English Communicative Question Paper With Solution",
            "CBSE 2016 English Communicative Question Paper With Solution Set-1",
            "CBSE 2016 English Communicative Question Paper With Solution Set-2",
            "CBSE 2018  English Communicative Question Paper With Solution",
            "CBSE 2019 Set Delhi 1 English Commutative Question Papers With Solution",
            "CBSE 2019 Set Aboard 2 English Commutative Question Papers With Solution",
            "CBSE 2019 Set All india 3 English Commutative Question Papers With Solution"};

    String[] EnglishBPapers = {"CBSE 2012 English Language & Literature Question Paper With Solution",
            "CBSE 2015 English Language & Literature Question Paper With Solution",
            "CBSE 2015 English Language & Literature Question Paper With Solution Set-1",
            "CBSE 2015 English Language & Literature Question Paper With Solution Set-2",
            "CBSE 2018  English Language & Literature Question Paper With Solution",
            "CBSE 2019 Set Delhi 1 English Language Question Papers With Solution",
            "CBSE 2019 Set Delhi 2 English Language Question Papers With Solution",
            "CBSE 2019 Set Delhi 3 English Language Question Papers With Solution"};




    String[] HindiAPapers = {"CBSE 2012 Hindi Course-A Question Papers With Solution",
            "CBSE 2013 Hindi Course-A Question Papers With Solution",
            "CBSE 2015 Hindi Course-A Question Papers With Solution",
            "CBSE 2016 Hindi Course-A Question Papers With Solution",
            "CBSE 2018  Hindi Course-A Question Paper With Solution",
    "CBSE 2019 Set Delhi 1 Hindi Course-A Question Papers With Solution",
            "CBSE 2019 Set Delhi 2 Hindi Course-A Question Papers With Solution",
            "CBSE 2019 Set Delhi 3 Hindi Course-A Question Papers With Solution"};

    String[] HindiBPapers = {"CBSE 2013 Hindi Course-B Question Papers With Solution",
            "CBSE 2014 Hindi Course-B Question Papers With Solution",
            "CBSE 2015 Hindi Course-B Question Papers With Solution",
            "CBSE 2016 Hindi Course-B Question Papers With Solution Set-1",
            "CBSE 2016 Hindi Course-B Question Papers With Solution Set-2",
            "CBSE 2016 Hindi Course-B Question Papers With Solution Set-3",
            "CBSE 2017 Hindi Course-B Question Papers With Solution",
            "CBSE 2018  Hindi Course-B Question Paper With Solution",
            "CBSE 2019 Set Delhi 2 Hindi Course-B Question Papers With Solution"};



    String[] SciPapers = {"CBSE 2007 Science Question Papers With Solution",
            "CBSE 2008 Science Question Papers With Solution",
            "CBSE 2009 Science Question Papers With Solution",
            "CBSE 2010 Science Question Papers With Solution",
            "CBSE 2011 Science Question Papers With Solution",
            "CBSE 2012 Science Question Papers With Solution",
            "CBSE 2013 Science Question Papers With Solution Set-1",
            "CBSE 2013 Science Question Papers With Solution Set-2",
            "CBSE 2014 Science Question Papers With Solution",
            "CBSE 2015 Science Question Papers With Solution Set-1",
            "CBSE 2015 Science Question Papers With Solution Set-2",
            "CBSE 2015 Science Question Papers With Solution Set-3",
            "CBSE 2016 Science Question Papers With Solution Set-3",
            "CBSE 2016 Science Question Papers With Solution Set-3 All India",
            "CBSE 2017 Science Question Papers With Solution",
            "CBSE 2018 Science Question Papers With Solution",
            "CBSE 2019 Set Delhi 1 Science Question Papers With Solution",
            "CBSE 2019 Set Delhi 2 Science Question Papers With Solution",
            "CBSE 2019 Set Delhi 3 Science Question Papers With Solution",
            "CBSE 2019 Set All india 1 Science Question Papers With Solution",
            "CBSE 2019 Set Aboard 2 Science Question Papers With Solution"};


    String[] MathsPapers = {"CBSE 2012 Maths Question Paper With Solution",
            "CBSE 2013 Maths Question Paper With Solution",
            "CBSE 2014 Maths Question Paper With Solution",
            "CBSE 2015 Maths Question Paper With Solution Set-1",
            "CBSE 2015 Maths Question Paper With Solution Set-2",
            "CBSE 2015 Maths Question Paper With Solution Set-3",
            "CBSE 2016 Maths Question Paper With Solution",
            "CBSE 2017 Maths Question Paper With Solution",
            "CBSE 2018 Maths Question Paper With Solution",
            "CBSE 2019 Set Delhi 1 Maths Question Papers With Solution",
            "CBSE 2019 Set Delhi 2 Maths Question Papers With Solution",
            "CBSE 2019 Set Delhi 3 Maths Question Papers With Solution"
            ,"CBSE 2019 Set Abroad 2 Maths Question Papers With Solution",
            "CBSE 2019 Set Aboard 3 Maths Question Papers With Solution",
            "CBSE 2019 Set All India 2 Maths Question Papers With Solution"};




    String[] SocialPapers = {"CBSE 2013 SocialScience Question Paper With Solution",
            "CBSE 2014 SocialScience Question Paper With Solution",
            "CBSE 2015 SocialScience Question Paper With Solution Set-1",
            "CBSE 2015 SocialScience Question Paper With Solution Set-2",
            "CBSE 2015 SocialScience Question Paper With Solution Set-3",
            "CBSE 2016 SocialScience Question Paper With Solution",
            "CBSE 2016 SocialScience Question Paper With Solution Set-1",
            "CBSE 2016 SocialScience Question Paper With Solution Set-3",
            "CBSE 2017 SocialScience Question Paper With Solution",
            "CBSE 2018 SocialScience Question Paper With Solution",
           "CBSE 2019 Set Delhi 1 Social Science Question Papers With Solution",
            "CBSE 2019 Set Delhi 2 Social Science Question Papers With Solution",
            "CBSE 2019 Set Delhi 3 Social Science Question Papers With Solution",
            "CBSE 2019 Set Aboard 2 Social Science Question Papers With Solution",
            "CBSE 2019 Set All india 2 Social Science Question Papers With Solution",
            "CBSE 2019 Set All india 3 Social Science Question Papers With Solution"};




    public String[] sample_paper_hindiA = {"sample paper 1 with solution","sample paper 2 with solution","sample paper 3 with solution"};
    public String[] sample_paper_hindiB = {"sample paper 1 with solution","sample paper 2 with solution","sample paper 3 with solution"};
    public String[] sample_paper_hindiA_list ={"https://drive.google.com/open?id=1dqDfr5J4TMcqf_Mm4GBC5ZMn7MncGI-U","https://drive.google.com/open?id=11VWjp6KSY-rQwIHeGO99c3TjCpyWzDx3","https://drive.google.com/open?id=1Kc46UVkStYLfqCIK85rN30qhmS_bEfe0"};
    public String[] sample_paper_hindiB_list ={"https://drive.google.com/open?id=134CpPxY-XNPRBlMkZ6dLYl-HmTlNRbR-","https://drive.google.com/open?id=1ycsm4KLBhLIT0rmAOFGaaSHH8xGBABiH","https://drive.google.com/open?id=1odDvRo7Vc7HS-ftYbt9OtHOgX8L0ydwC"};
    public String[] sample_paper_hindiA_list_sol ={"https://drive.google.com/open?id=1-O8eQVm9i-cNuCGDmnxBfWRNsAf3uQ7e","https://drive.google.com/open?id=1XuZdW3nJq6Xd-aPoqXHsYnlackRSE_yh","https://drive.google.com/open?id=1epZeBNtjZ3QjJON5ZjfRPmarAAMupzkD"};
    public String[] sample_paper_hindiB_list_sol ={"https://drive.google.com/open?id=19zpZM1cP3iiJZfis9OXCYstI1PBHJ0IA","https://drive.google.com/open?id=1i2RF5okFXb9dx4TuP6jtqa3Xg0g222Pd","https://drive.google.com/open?id=1JwArqveiZ9vGMpTembRBz4qzGis6M4ah"};


    String[] hindia_ncert_textbook = {"https://drive.google.com/open?id=1cudahzXekzrtZtqffjpMn1ho7m8iiEio",
            "https://drive.google.com/open?id=1XM3x8-prHlNtzi2wvU7lMWzSWziUDCBD","https://drive.google.com/open?id=1-fxEkgVMpa6kF-RAK_VjosdMKM2fOs26","https://drive.google.com/open?id=1EMxmVVsViEz-0PKIa6RgwN8cdJPa7u1f","https://drive.google.com/open?id=1Q8A5YX8ycgrBQ0PD_mamQ--FzANRBmsA","https://drive.google.com/open?id=12KorWN7dh9Pa1NiCRj1_62FuAbdlfvdC","https://drive.google.com/open?id=1V0-3iAp9BoTM8Okf1Xqhf7L4W3Oif0_m","https://drive.google.com/open?id=1PV0gZfQ_pdNFkjHK8rSTrVebIynrDvgv","https://drive.google.com/open?id=1oJTdvZuCQfyw_wGxteL-aGJZBnERdev1","https://drive.google.com/open?id=1ZWFisZEj_91kJxu2Rtlsh4OqCkmDj4jV","https://drive.google.com/open?id=1C9c0G8TLRGSKkd0p9XaQtk3hMnzwS-F8","https://drive.google.com/open?id=1ifLk4n_FpmDYJeoZGWW3GwYo5GpHuCbw","https://drive.google.com/open?id=1qmxkPmLpEYYisbnH-vbPtydKLeR-UUXL","https://drive.google.com/open?id=1zx8nGQRwXhv4V03G2on1EDyVUtGxoOEF","https://drive.google.com/open?id=1VMOn-60GCOl4pEcorkBW95NVzXfuZUD3","https://drive.google.com/open?id=1MYD9ACPW49Uw5YM7vcp7ovtSAY3UgZQF","https://drive.google.com/open?id=1L3MnUed4u_zzKdTkAZ2CuuSUqVff5QAR","https://drive.google.com/open?id=1fpIr33D8GaOWmTeOtCSpPy1aOk0HfNel","https://drive.google.com/open?id=1dKcmrkCJmybyQKsu0ADVG6Ibia_3njGv","https://drive.google.com/open?id=1CE7R4cRFw5hiVtwV9G8KVV2FcQLjI6lm","https://drive.google.com/open?id=1ZnKisiEahkocUj1OpNmGjtVSEIEtXoQY","https://drive.google.com/open?id=1IoChdCN2DpgG6Z4FJLWlSMGr1BGoajOH"};
    String[] hindib_ncert_textbook = {"https://drive.google.com/open?id=1sbFP3XnHhSZbpkvi72GP0yA8lT9J4Beq",
            "https://drive.google.com/open?id=1F9T4YfCpTx2ZrONpioMMqzty-mLnyTcj",
            "https://drive.google.com/open?id=1PzpfH92QVD015our1colWvcyyKlEEzg5",
            "https://drive.google.com/open?id=1MBn0AMn1n80Oxx0qX4IusVpY1vDAi2ws",
            "https://drive.google.com/open?id=1wQEUUmJPAuJMRODToD6dKdyK2SNFi5Qq",
            "https://drive.google.com/open?id=1iXG-S2yA3-iFq-hkvWztKUSO7eePyIfj",
            "https://drive.google.com/open?id=1AJxVL9exDJvLcajV3Mu5NacaLEDGBmsO",
            "https://drive.google.com/open?id=10FSIdPU18ggp3ZqK026XVaSsFs8ggH1c",
            "https://drive.google.com/open?id=1M48ouTGi5mBtQVahJkYiJAi8hKSEgW-m",
            "https://drive.google.com/open?id=1JzKLto0vde2_NRTlwC_4Y7msK7BT2LpP",
            "https://drive.google.com/open?id=1iXDFWGI7GSAPWmkRRCiabV34v2Or8NQT",
            "https://drive.google.com/open?id=1uio7Rj_MuEBkMuUGRlg7muWv8AlR3_0S",
            "https://drive.google.com/open?id=1PDqOaAlW6Uj7QR7bqVx1QSH2jW3RgerR",
            "https://drive.google.com/open?id=1bhrPgaiinM1gm0m9pRst0oGmXyTLdzHc",
            "https://drive.google.com/open?id=1YuqbID6JWvEHG7GA6a_ihY51nZBqw4RE",
            "https://drive.google.com/open?id=1mnNI6nlPd7ismYiVCDCJyKyvXhrL_YyO",
            "https://drive.google.com/open?id=18yUyTVmXv1JAFPYR1fkd2pq4apRk7TVg",
            "https://drive.google.com/open?id=15zEQwuY6t-jm8jF2-NCfD4ixP4ciAXKw",
            "https://drive.google.com/open?id=1KwWNwgb0kHxiVDwnu68mjmoggAYPYX7Q",
            "https://drive.google.com/open?id=1z_cPUcvix9yxOI3vUVSMQocz2CjefKPE"};
    String[] HindibBook_text = {"संचयन पाठ-01 हरिहर काका",
            "संचयन पाठ-02 सपनों के – से दिन",
            "संचयन पाठ-03 टोपी शुक्ला",
            "स्पर्श पाठ-01 कबीर [कविता]",
            "स्पर्श पाठ-02 मीरा [कविता]",
            "स्पर्श पाठ-03 बिहारी [कविता]",
            "स्पर्श पाठ-04 मैथिलीशरण गुप्त [कविता]",
            " स्पर्श पाठ-05 सुमित्रानंदन पंत [कविता]",
            "स्पर्श पाठ-06 महादेवी वर्मा [कविता]",
            "स्पर्श पाठ-07 वीरेन डंगवाल [कविता]",
            " ्पर्श पाठ-08 कैफ़ी आजमी [कविता]",
            "हबीब तनवीर",
            "प्रेमचंद",
            "सीताराम सेकसरिया",
            "लीलाधर मंडलोई",
            "प्रहलाद अग्रवाल",
            "अंतोन चेखव",
            "िदा फ़ाज़ली",
            "रवींद्र केलेवर",
            "रवींद्रनाथ ठाकुर [कविता]"};

    //CBSE HINDI A
    String[] HindiAsyllabus = {"https://drive.google.com/open?id=1bpCwyJROqAx924lCtJQnMAXqDHxF_nJ5"};

    //CBSE HINDI B
    String[] HindiBsyllabus = {"https://drive.google.com/open?id=1Bfa8YQ72kQ1Qq4Hg1xRHcAzouxvE1HRe"};

    String[] sample_paper_sank_name = {"Sample paper 1"};
    String[] sample_paper_sansk = {"https://drive.google.com/open?id=1KyTrNSN_c9j9vDcbYDWaAcK5rQW_Y64Y"};

    String[] san_title = {"मनिका(X)_book","शेमुषि (X)_book"};

    String[] sanskrit_paper_ti = {"sanskrit_2018_all_india", "sanskrit_2017_delhi", "sanskrit_2016_all_india", "sanskrit_2015_all_india", "sanskrit_2015_delhi"};
 //   String[] sanskrit_paper_ti = {"sanskrit_2018_all_india","sanskrit_2017_all_india","sanskrit_2017_foreign","sanskrit_2017_delhi","sanskrit_2016_all_india","sanskrit_2016_foreign","sanskrit_2016_delhi","sanskrit_2015_all_india","sanskrit_2015_foreign","sanskrit_2015_delhi"};
    String[] sanskrit_paper_ti_sol = {"sanskrit_2018_all_india_sol","sanskrit_2017_all_india_sol","sanskrit_2017_foreign_sol","sanskrit_2017_delhi_sol","sanskrit_2016_all_india_sol","sanskrit_2016_foreign_sol","sanskrit_2016_delhi_sol","sanskrit_2015_all_india_sol","sanskrit_2015_foreign_sol","sanskrit_2015_delhi_sol"};
    String[] sanskrit_paper = {"https://drive.google.com/open?id=1_gGa7i1vdXWMHwApN5q5aQyOHTOkp8Xj","https://drive.google.com/open?id=1ZnOBXA4_TBpC15m-ZkedrTbCYnmqhngg","https://drive.google.com/open?id=1fHTXb_8FVvOgtkZf6EqZbysNvaRrwgME","https://drive.google.com/open?id=1MpunETJSuj8mf_8xw9DM6-4n1-ULig-5","https://drive.google.com/open?id=1trBc9mX2SUScNu-tfv_ZxA0mTgX1ug5-"};
    String[] sanskrit_paper_solution_d = {"https://drive.google.com/open?id=1IzRfHr6FNegbwHXw0p0PObadvpMnjxIn","https://drive.google.com/open?id=1o1Db3vxWYOupt2-Xf2tKCFZhrCJph-_O","https://drive.google.com/open?id=1KqXb380dOCXeCtdFBpus9yKQg6-8QJtq","https://drive.google.com/open?id=1-p3wbavquXACeiFwf6APPqq8MEBbT_CG","https://drive.google.com/open?id=1WLg6SqbdLk29KTgjTSWp2_Qm29Dg7HsU"};

    String[] sanskrit_ncert_sol_maniks = {"मनिका_1","मनिका_2","मनिका_3","मनिका_4","मनिका_5","मनिका_6","मनिका_7","मनिका_8","मनिका_9","मनिका_10","मनिका_11"};
    String[] sanskrit_ncert_sol_maniks_url = {"https://drive.google.com/open?id=1ddADgakIK5GOCvoVBEIKMSSptQwSd8Hs","https://drive.google.com/open?id=14ukvvAOvCm9ECP4VKK1CSDE0x8bPpMYE","https://drive.google.com/open?id=1mnd8ukHHKLVFgtlroCvn5FSKm0rltGIC","https://drive.google.com/open?id=1Do01AU4z9YZDr2QpgzAtMeUjEjaksCNN","https://drive.google.com/open?id=1TgSDNCIloP36e0V2DZirxQdPpR7cv4cD","https://drive.google.com/open?id=1M3AI5tjSm33WeMXpe55lIV1Kzvo4Ifxt","https://drive.google.com/open?id=1W1HiB1VCKDqICXlG2Z9lxahsqHigUmmV","https://drive.google.com/open?id=1VZs8gE7cuiRDmAyhmk6w6Oci98DsG0w-","https://drive.google.com/open?id=1PnbpZNGa8_avvodVcuqWJ5-Yu2LH-srO","https://drive.google.com/open?id=1qmC-8i7oWNjZVMY3qjN75JyJyx8Zw6gW","https://drive.google.com/open?id=1YOBLU3nsSPffgvd-k5oFuLjQ_FZmmTeT"};

    String[] sanskrit_syllabus= {"https://drive.google.com/open?id=1MOBy8ToTWrpo4cQujQyE9Yw94pbzhljf"};

    AdRequest adRequest1;

    String[] EnglishAvideos = {"Reading-Factual Passage", "Writing-Diary Entry", "Writing-Short Story", "Writing-Formal Letters",
            "Grammar-Gap Filling", "Grammar-Editing", "Grammar-Omission", "Grammar-Sentence Reordering", "Grammar-Sentence Transformation",
            "Fiction ch01 Two Gentlemen of Verona", "Fiction ch02 Mrs Packletides Tigers", "Fiction ch03 The Letter", "Fiction ch04 A Shady Plot",
            "Fiction ch05 Patol Babu Film Star", "Fiction ch06 Virtually True", "Poem ch01 The Frog and the Nightingale", "Poem ch02 Mirror",
            "Poem ch03 Not Marble nor the Gilded Monuments", "Poem ch04 Ozymandias", "Poem ch05 The Rime of the Ancient Mariner", "Poem ch06 Snake",
            "Drama ch01 The Dear Departed", "Drama ch02 Julius", "Novel The Story of My Life", "Novel Diary of a Young Girl"};

    String[] EnglishBVideos = {"Reading-Factual Passage", "Writing-Diary Entry", "Writing-Formal Letters", "Writing-Short Story", "Grammar-Gap Filling",
            "Grammar-Editing", "Grammar-Omission", "Grammar-Sentence Reordering", "Grammar-Sentence Transformation", "First Flight ch01 A Letter to God",
            "First Flight ch02 Long Walk to Freedom", "First Flight ch03 Two Stories about Flying", "First Flight ch04 From the Diary of Anne Frank",
            "First Flight ch05 The Hundred Dresses I", "First Flight ch07 Glimpses of India", "First Flight ch08 Mijbil the Otter", "First Flight ch09 Madam Rides the Bus",
            "First Flight ch11 The Proposal", "First Flight Poem ch01 Dust of snow", "First Flight Poem ch02 Fire and Ice", "First Flight Poem ch03 A Tiger in the Zoo",
            "First Flight Poem ch04 How to Tell Wild Animals", "First Flight Poem ch05 The Ball Poem", "First Flight Poem ch06 Amanda", "First Flight Poem ch07 Animals",
            "First Flight Poem ch08 The Trees", "First Flight Poem ch09 Fog", "First Flight Poem ch10 The Tale of Custard the Dragon", "First Flight Poem ch11 For Anne Gregory",
            "Footprints ch01 A Triumph of Surgery", "Footprints ch02 The Thiefs Story", "Footprints ch03 The Midnight Visitor", "Footprints ch04 A Question of Trust",
            "Footprints ch05 Footprints without Feet", "Footprints ch06 The Making of a Scientist", "Footprints ch07 The Necklace", "Footprints ch08 The Hack Driver",
            "Footprints ch09 Bholi", "Novel The Story of My Life", "Novel Diary of a Young Girl"};


    String[] HindiAVideos = {"अपठित गद्यांश", "अपठित काव्यांश", "व्याकरण वाक्य भेद", "व्याकरण वाच्य", "व्याकरण पद परिचय", "व्याकरण रस", "निबंध लेखन", "पत्र लेखन",
            "विज्ञापन लेखन", "सूरदास", "तुलसीदास", "देव", "जयशंकर प्रसाद", "सूर्यकांत त्रिपाठी निराला", "नागार्जुन", "गिरिजाकुमार माथुर", "ऋतुराज", "मंगलेश डबराल", "नेताजी का चश्मा",
            "बालगोबिन भगत", "लखनवी अंदाज़", "मानवीय करुणा की दिव्य चमक", "एक कहानी यह भी", "स्त्री-शिक्षा के विरोधी और कुतर्कों का खंडन", "नौबतखाने में इबादत", "संस्कृति",
            "माता का ऑचल", "जॉर्ज पंचम के नाक", "साना-साना हाथ जोड़ी", "एही ठेयाँ झुलनी हेरानी हो रमा", "मै क्यों लिखता हूँ"};

    String[] HindiBVideos = {"अनुच्छेद लेखन", "पत्र लेखन", "सूचना लेखन", "संवाद लेखन", "विज्ञापन लेखन", "साखी", "पद", "दोहे", "मनुष्यता", "पर्वत प्रदेश में पावस",
            "मधुर-मधुर मेरे दीपक जल", "पतझर में टूटी पत्तियाँ", "तोप", "कर चले हम फ़िदा", "आत्मत्राण", "बड़े भाई साहब", "डायरी का एक पन्ना", "तताँरा-वामीरो कथा", "तीसरी कसम के शिल्पकार शैलेंद्र",
            "गिरगिट", "अब कहाँ दूसरे के दुख से दुखी होने वाले", "कारतूस", "हरिहर काका", "सपनों के-से दिन", "टोपी शुक्ला"};


    String[][] Sylabuus = {mathsSyllabus,ScienceSyllabus,SocialScienceSyllabus,EnglishComunitySyllabus,EnglishComunitySyllabus,HindiAsyllabus,HindiBsyllabus,sanskrit_syllabus};
    public String[] syllabus_urls = {"https://drive.google.com/open?id=1kdVnUfZ4rb4lS4Yria6cGvr6vFqPRL2O",
            "https://drive.google.com/open?id=1GjM5_OANW-f3fzMO7AFr_OKgA6uDQgg6",
            "https://drive.google.com/open?id=1xKwVkAbQBCEmIMzs3pBafqGMcNVmD6ql",
            "https://drive.google.com/open?id=1fqEpXgSMUjvjAwtVUYiUn9f7bbpeJmtB",
            "https://drive.google.com/open?id=1fqEpXgSMUjvjAwtVUYiUn9f7bbpeJmtB",
            "https://drive.google.com/open?id=1bpCwyJROqAx924lCtJQnMAXqDHxF_nJ5",
            "https://drive.google.com/open?id=1Bfa8YQ72kQ1Qq4Hg1xRHcAzouxvE1HRe",
            "https://drive.google.com/open?id=1MOBy8ToTWrpo4cQujQyE9Yw94pbzhljf"};


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        final AdView mAdView = findViewById(R.id.adView);
        final AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
                super.onAdClicked();
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                mAdView.loadAd(adRequest);
            }

            @Override
            public void onAdImpression() {
                super.onAdImpression();
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }

            @Override
            public void onAdSwipeGestureClicked() {
                super.onAdSwipeGestureClicked();
            }
        });


        

        Intent intent = getIntent();
        if (intent != null) {
            subject_position = intent.getIntExtra("subject_position", 0);
            sub_name = intent.getStringExtra("subject_name");
            Log.i("subject_position", String.valueOf(subject_position));
        }

        AppController application = (AppController) this.getApplication();
        Tracker mTracker = application.getDefaultTracker();
        mTracker.setScreenName("screen name:" + "Content List");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());

        // Obtain the FirebaseAnalytics instance.
        FirebaseAnalytics mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "Subject_Contain");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Subject_Contain");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(sub_name);


        grid_view = findViewById(R.id.grid_view);

        if(subject_position == 0) {
            grid_view.setAdapter(new Content_Adapter(this, content_icons_maths, content_names_maths));
        }
        if(subject_position == 1) {
            grid_view.setAdapter(new Content_Adapter(this, content_icons_science, content_names_science));
        }
        if(subject_position == 2) {
            grid_view.setAdapter(new Content_Adapter(this, content_icons_social, content_names_social));
        }
        if(subject_position == 3) {
            grid_view.setAdapter(new Content_Adapter(this, content_icons_English_commutative, content_names_English_commutative));
        }
        if(subject_position == 4) {
            grid_view.setAdapter(new Content_Adapter(this, content_icons_English_language, content_names_English_language));
        }
        if(subject_position == 5) {
            grid_view.setAdapter(new Content_Adapter(this, content_icons_hindiA, content_names_hindiA));
        }
        if(subject_position == 6) {
            grid_view.setAdapter(new Content_Adapter(this, content_icons_hindiB, content_names_hindiB));
        }
        if(subject_position == 7) {
            grid_view.setAdapter(new Content_Adapter(this, content_icons_sanskrit, content_names_sanskrit));
        }
        grid_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = null;
                switch (position) {
                    case 0:

                        if(subject_position == 0) {
                            intent = new Intent(ContentActivity.this, OpenFile.class);
                            intent.putExtra("title", content_names_maths[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("contenturl", syllabus_urls[subject_position]);
                        }
                        if(subject_position == 1) {
                            intent = new Intent(ContentActivity.this, OpenFile.class);
                            intent.putExtra("title", content_names_science[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("contenturl", syllabus_urls[subject_position]);
                        }
                        if(subject_position == 2) {
                            intent = new Intent(ContentActivity.this, OpenFile.class);
                            intent.putExtra("title", content_names_social[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("contenturl", syllabus_urls[subject_position]);
                        }
                        if(subject_position == 3) {
                            intent = new Intent(ContentActivity.this, OpenFile.class);
                            intent.putExtra("title", content_names_English_commutative[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("contenturl", syllabus_urls[subject_position]);
                        }
                        if(subject_position == 4) {
                            intent = new Intent(ContentActivity.this, OpenFile.class);
                            intent.putExtra("title", content_names_English_language[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("contenturl", syllabus_urls[subject_position]);
                        }

                        if(subject_position == 5) {
                            intent = new Intent(ContentActivity.this, OpenFile.class);
                            intent.putExtra("title", content_names_hindiA[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("contenturl", syllabus_urls[subject_position]);
                        }

                        if(subject_position == 6) {
                            intent = new Intent(ContentActivity.this, OpenFile.class);
                            intent.putExtra("title", content_names_hindiB[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("contenturl", syllabus_urls[subject_position]);
                        }
                        if(subject_position == 7) {
                            intent = new Intent(ContentActivity.this, OpenFile.class);
                            intent.putExtra("title", content_names_sanskrit[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("contenturl", syllabus_urls[subject_position]);
                        }

                        break;
                    case 1:
                        if(subject_position == 0) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_maths[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", MathsNotes111);
                            intent.putExtra("fileurls", maths_txt);

                        }
                        if(subject_position == 1) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_science[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", ScienceNotes);
                            intent.putExtra("fileurls", sci_txt);

                        }
                        if(subject_position == 2) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_social[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", SocialBook);
                            intent.putExtra("fileurls", soc_txt);

                        }
                        if(subject_position == 3) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_English_commutative[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", sample_paper_englishA);
                            intent.putExtra("fileurls", Englishasample_list);
                            intent.putExtra("solution_urls", Englishasample_list_sol);

                        }
                        if(subject_position == 4) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_English_language[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", Englishbtextbookff);
                            intent.putExtra("fileurls", eng_txt);

                        }
                        if(subject_position == 5) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_hindiA[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", HindiaBook);
                            intent.putExtra("fileurls", hindia_ncert_textbook);

                        }

                        if(subject_position == 6) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_hindiB[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", HindibBook_text);
                            intent.putExtra("fileurls", hindib_ncert_textbook);

                        }
                        if(subject_position == 7) {
                            intent = new Intent(ContentActivity.this, FolderActivity.class);
                            intent.putExtra("title", content_names_sanskrit[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", san_title);

                        }
                        break;

                    case 2:

                        if(subject_position == 0) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_maths[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", sample_paper_maths);
                            intent.putExtra("fileurls", maths_sample_paper);
                            intent.putExtra("solution_urls", maths_sample_paper_solution);
                        }
                        if(subject_position == 1) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_science[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", sci_sample_paper);
                            intent.putExtra("fileurls", sci_sample_paper_list);
                            intent.putExtra("solution_urls", sci_sample_paper_list_sol);
                        }
                        if(subject_position == 2) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_social[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", sample_paper_social);
                            intent.putExtra("fileurls", sample_paper_social_science_list);
                            intent.putExtra("solution_urls", sample_paper_social_science_list_sol);
                        }
                        if(subject_position == 3) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_English_commutative[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", EnglishAPapers);
                            intent.putExtra("fileurls", EnglishComunityLastYearPaper);
                            intent.putExtra("solution_urls", EnglishComunityLastYearPaperSolution);
                        }

                        if(subject_position == 4) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_English_language[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", sample_paper_englishB);
                            intent.putExtra("fileurls", sample_paper_englishB_list);
                            intent.putExtra("solution_urls", sample_paper_englishB_list_sol);

                        }
                        if(subject_position == 5) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_hindiA[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", sample_paper_hindiA);
                            intent.putExtra("fileurls", sample_paper_hindiA_list);
                            intent.putExtra("solution_urls", sample_paper_hindiA_list_sol);

                        }
                        if(subject_position == 6) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_hindiB[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", sample_paper_hindiB);
                            intent.putExtra("fileurls", sample_paper_hindiB_list);
                            intent.putExtra("solution_urls", sample_paper_hindiB_list_sol);

                        }
                        if(subject_position == 7) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_sanskrit[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", sample_paper_sank_name);
                            intent.putExtra("fileurls", sample_paper_sansk);

                        }

                        break;
                    case 3:
                        if(subject_position == 0) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_maths[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", MathsPapers);
                            intent.putExtra("fileurls", mathsPaper);
                            intent.putExtra("solution_urls", mathsPaperSolution);
                        }
                        if(subject_position == 1) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_science[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", SciPapers);
                            intent.putExtra("fileurls", ScienceLastYearPaper);
                            intent.putExtra("solution_urls", ScienceLastYearSolution);
                        }

                        if(subject_position == 2) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_social[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", SocialPapers);
                            intent.putExtra("fileurls", SocialScienceLastYearPaper);
                            intent.putExtra("solution_urls", SocialScienceLastYearPaperSolution);
                        }
                        if(subject_position == 3) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_English_commutative[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", EnglishaNotes_dubli);
                            intent.putExtra("fileurls", EnglishaNotes_sol);
                        }
                        if(subject_position == 4) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_English_language[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", EnglishBPapers);
                            intent.putExtra("fileurls", EnglishLanguageLastYearPaper);
                            intent.putExtra("solution_urls", EnglishLanguageLastYearPaperSolution);
                        }
                        if(subject_position == 5) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_hindiA[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", HindiAPapers);
                            intent.putExtra("fileurls", HindiALastYearPaper);
                            intent.putExtra("solution_urls", HindiALastYearPaperSolution);
                        }
                        if(subject_position == 6) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_hindiB[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", HindiBPapers);
                            intent.putExtra("fileurls", HindiBLastYearPaper);
                            intent.putExtra("solution_urls", HindiBLastYearPaperSolution);
                        }
                        if(subject_position == 7) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_sanskrit[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", sanskrit_paper_ti);
                            intent.putExtra("fileurls", sanskrit_paper);
                            intent.putExtra("solution_urls", sanskrit_paper_solution_d);
                        }
                        break;
                    case 4:
                        if(subject_position == 0) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_maths[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", MathsNotes);
                            intent.putExtra("fileurls", mathsRevisednotes1);
                        }
                        if(subject_position == 1) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_science[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", ScienceNotes);
                            intent.putExtra("fileurls", scirevision);
                        }

                        if(subject_position == 2) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_social[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", social_revi_title);
                            intent.putExtra("fileurls", SocialSciencerevision);
                        }

                        if(subject_position == 3){
                            intent = new Intent(ContentActivity.this, FolderActivity.class);
                            intent.putExtra("title", content_names_English_commutative[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", EnglishAvideos);

                        }

                        if(subject_position == 4) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_English_language[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", EnglishbBook);
                            intent.putExtra("fileurls", EnglishbBook_new_ncert_sol);
                        }
                        if(subject_position == 5) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_hindiA[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", HindiaBook);
                            intent.putExtra("fileurls", hindiA_new_ncert_sol);
                        }
                        if(subject_position == 6) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_hindiB[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", HindibBook);
                            intent.putExtra("fileurls", hindiB_new_ncert_sol);
                        }
                        if(subject_position == 7) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_hindiB[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", sanskrit_ncert_sol_maniks);
                            intent.putExtra("fileurls", sanskrit_ncert_sol_maniks_url);
                        }


                        break;
                    case 5:
                        if(subject_position == 0) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_maths[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", MathsNotes23);
                            intent.putExtra("fileurls", mathsiwmpo);
                        }
                        if(subject_position == 1) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_science[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", ScienceNotes);
                            intent.putExtra("fileurls", sciiwmpo);
                        }
                        if(subject_position == 2) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_social[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", SocialBook);
                            intent.putExtra("fileurls", SocialSciencencertsolution);
                        }
                        if(subject_position == 4){
                            intent = new Intent(ContentActivity.this, FolderActivity.class);
                            intent.putExtra("title", content_names_English_language[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", EnglishBVideos);

                        }
                        if(subject_position == 5){
                            intent = new Intent(ContentActivity.this, FolderActivity.class);
                            intent.putExtra("title", content_names_hindiA[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", HindiAVideos);

                        }
                        if(subject_position == 6){
                            intent = new Intent(ContentActivity.this, FolderActivity.class);
                            intent.putExtra("title", content_names_hindiA[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", HindiBVideos);

                        }
                        break;
                    case 6:
                        if(subject_position == 0) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_maths[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", Mathsvideo);
                            intent.putExtra("fileurls", mathsnewNcertSolution);
                        }
                        if(subject_position == 1) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_science[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", ScienceNotes);
                            intent.putExtra("fileurls", ScienceNcertSolution);
                        }
                        if(subject_position == 2) {
                            intent = new Intent(ContentActivity.this, FolderActivity.class);
                            intent.putExtra("title", content_names_social[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", SocialImp);

                        }

                        break;
                    case 7:
                        if(subject_position == 0) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_maths[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", MathsNotes555);
                            intent.putExtra("fileurls", mathsnewNcertSolution_example);
                        }

                        if(subject_position == 1) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_science[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", ScienceNotes);
                            intent.putExtra("fileurls", ScienceNcertSolution_example);
                        }

                        break;



                    case 8:

                        if(subject_position == 0) {
                            intent = new Intent(ContentActivity.this, FileActivity.class);
                            intent.putExtra("title", content_names_maths[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", maths_rs_agarwal_title);
                            intent.putExtra("fileurls", maths_rs_agarwal);
                        }

                        if(subject_position == 1){
                            intent = new Intent(ContentActivity.this, FolderActivity.class);
                            intent.putExtra("title", content_names_science[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", ScienceNotes);

                        }
                        break;


                    case 9:

                        if(subject_position == 0) {
                            intent = new Intent(ContentActivity.this, FolderActivity.class);
                            intent.putExtra("title", content_names_maths[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", rd_sharma_title10);

                        }


                        break;
                    case 10:

                        if(subject_position == 0){
                            intent = new Intent(ContentActivity.this, FolderActivity.class);
                            intent.putExtra("title", content_names_maths[position]);
                            intent.putExtra("subject_position", subject_position);
                            intent.putExtra("content_position", position);
                            intent.putExtra("filesnamelist", Mathsvideo);

                        }

                        break;

                }

                if (intent != null) {
                    startActivity(intent);
                }
            }
        });
    }
}
