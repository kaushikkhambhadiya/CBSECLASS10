package com.omeducation.cbscclass10board;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;

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

import java.util.ArrayList;

import static com.omeducation.cbscclass10board.Config.clickNumber;

public class VideoListActivity extends AppCompatActivity {

    GridView gv;

    //class 11 commerce


    String[] m1 = {"9exHO9iw14c", "5tou1Rbhi8M", "6TzJe3eqqlg", "eexpITiv9NE", "yHxuj5QOnfQ", "W341u6Cwl4Q", "RcU3u7pmQxY", "Tq0oUW24rto", "JRN8Dqf6acM", "pTvqmMrzink"};
    String[] m2 = {"6MOz21PlVMQ", "jWkbSxqDgQI", "Lthc3LcxZBw", "QXOLozXkAvs", "3q7yhp19mbc", "8x3-2U36jdI", "tdeQwInVcuY", "W34P527oT7A", "2ZdFEXrA_9w", "ITvifxhHDkk", "ALGE2uxp9c8", "erPa_39A3QA", "K3hVKBmyUXg"};
    String[] m3 = {"0Hih-ppb5CQ", "0WgJXC1IMgs", "GWHMVwxuN4A", "GernypBLC04", "7ZeuCsRdThs", "J3AlFwwzuws", "MqEudMjFGYk", "3NTzg_ATRg4", "KEmMDLgKI9s", "AZq4_hzDR7k", "7GuqurZFIZQ", "J4A5rNXwlLs", "ibSF7n4iVPM", "qqRt_m6rrlM", "pvvpSGc-OSk", "82sSYwctw2E", "LFxODMfVbjg", "ecnt0AlV9i0", "_HJeZlpt4dc", "g3rcSZnRWxw"};
    String[] m4 = {"zoSv6HUQ0TI", "8OKGL3ut3Kk", "o10-mp89jhw", "9qckorw9HdM", "fiIF6__YgoQ", "MRhjnznqU2Q", "BPSxjh04eNg", "Eob9SOf5DzQ", "cIZi_taMEVY", "zUEBpW13FEs", "T_7O5VO2ihg", "GxUVVOb3ywE"};
    String[] m5 = {"7VvtMLXLt3Q", "dv3lcYhxZEM", "el8c-dJk2XA", "U9R6kyFa3MU", "_9bonmuyDbs", "5KY0yreA1kw", "ukbRDD_I6xs", "M5Haqo_VcQc", "gAP0TWwHdrE", "R85o0DdbJ6c", "cRyeMph7tKU", "d5JBjoz76lQ", "AJwACuH9j5M", "0p_yi9WXjBs"};
    String[] m6 = {"G2jYqF4l0aI", "edtFK_7uViQ", "esEj5CGs8r4", "daE_2DZQ2Pw", "hfwabjyqd-s", "vr6yrovrd2Y", "mkTovfFWTTs", "vbEsqJ6CeUM", "gCUUL7bENxU", "QVboC-iKElQ", "Pun4JnRgp0E", "BRdSPqRpP2E", "3EMJJIl902Q", "pTXI1PC3v1k", "7TxbO0rhHf8", "R57U9zbuzDY", "EQRcI-BEOKg", "gGigOFAYsN4", "rvWz4n2x0HY", "Pj-NmwISTHQ", "ASXh7CLN208", "nQ8B2e1pGTU", "LM7OD9HGC38", "P0ddHIN1xgw", "onhCxUByork", "Amx5HGt6Y6o", "uYBh524xm5M", "E2_PZaZAprM", "ibJcx-VVZxc", "Bc2krbb95Sc", "TX3GSWsK7n8", "LfYevsAhdV4", "JR2ePLF0cxA", "RUIivsa27Fw", "AaxRxo56eZc", "pD5dezT2nGU", "210qR01kvEg", "yg5wiiBb5Js", "IV3qw8t4I6I", "nuRg3EVv7Ec", "9Drxx3EkFu4", "M-5LFV3gcrA", "A_OgSTQfT8A", "x1YKVWR2_Nk", "GPKPOai95-Q", "cVtzm3q0hvU", "N904_Rqb_e4"};
    String[] m7 = {"nxht1L8Qw18", "QYAnXiZC5kQ", "yLlXOSAwpDw", "HjYt8AfMnJE", "4P56X6pQV8Q", "P_gZFFf518Y", "qnNZTZdnl90", "67V9u4icdYI", "XYWpfpbqdbA", "fNF3u2rTccY", "_X7A_YyjT1E", "hqU3pmMAbXM", "Sqn4wCmqNDA", "U1pn0bOZtyo", "riG0Tw7w7PI", "0sFZNb5Tt4g", "kpvfS_e-hrA", "_BQFt_TkYOs"};
    String[] m8 = {"0OGSoQxUqJo", "nf69QEuQ1IM", "LTSEn67gRl4", "FTVJzHRRBfI", "8gcIs8lIlao", "PEYX2c5Yr00", "63LC1ZHu8Vo", "3XWzgeqYfQ8", "SMHIXFqd3s4", "qv9e4z3wP5E", "AXVB-jpStXM", "lAmXPXvVrS0", "tsn0yTgzNBE", "YR-Gu7kYZ8M", "LFNpUw2myWA", "3e3k1YH7G40"};
    String[] m9 = {"0Cz2DJ_bujo", "LY5Zk9KZyAI", "cNq6Utkj9D0", "ZPoFq0SSxy4", "GyGKE8JFqrk", "UlUqo8RmxbY", "8gTCEvlNo-0"};
    String[] m10 = {"COiGT5t4Uyc", "eqs0VaBvg3Y", "gl6p3UynrIQ", "l7BX-UPxEn8", "t2BCyexezkI", "lv8mBuuuu94", "PZph3SAsgi4", "bHWzFLD0qNc"};
    String[] m11 = {"vvKMJVSLvnM", "xGHAyVdxiWQ", "sF2Zj0C_Otw"};
    String[] m12 = {"0aU95OrtpPw", "cY4huPW85HU", "JEU580_rep4", "_tstRggRk_s", "NUhHyZjdzRU", "w4OBwKd_cX0", "rqZJ40lS2zs", "6Q2Ck7sg5Gs", "wN3sjSVU0rY", "QJi_DUDOBFw", "KwfYxUPpJEY", "taEQc0QNUzg", "vrXCfSg_-P0", "ZSp3WBrM9O0", "DzJO7AEaSwM"};
    String[] m13 = {"s3KPuK3hTD4", "-fwCNbeN3IU", "CXMetJK5_HI", "uiMqRfdU1CY", "MQsBpSDqo_k", "sGXElQi_xzM", "9B12X9n2WbY", "DIKGBzj2bnQ", "PzdT5jvIekc", "z-yZVCM0DhE", "kTm_S5Zk9K0", "E_gi6FUr7uE", "kTm_S5Zk9K0", "c4scQqg8QjE", "flK23NeAtLs", "fs3w0wiQo8I", "kBe4-La97J8", "9g4p2VnuR50", "81CieEnijAU", "3yGXMX4ULT4"};
    String[] m14 = {"yNwlLyj2Dc0", "9xBgRYkAYVE", "8BFUYZQ0ts4", "F0hOlPh-9MU", "124O2YuT7qc", "xsHHRdn82zw", "8MXpe4fPvAY", "hP3ydDh3b6c", "QI0SVnmgQOk", "3BG5-UVZY6k", "bybGmuhR_Jg", "Q4yG6so0FL0", "J1KxGI0wKcs", "ORBKy1AHQsE", "O0Ku37RbNpU"};
    String[] m15 = {"FT1s40P-cY8", "khrBJeblWlY", "PY0B0MSVpeA", "f__76iwsXEo", "HUrs9xoCgYY", "0wG2c0rHdWY", "651EbIOD3ho", "uovuQOD_Fn4", "yf7XErTHRuY", "D6O31q2-tvA"};
    String[][] Mathsvideos = {m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12, m13, m14, m15};

    String[] s1 = {"jKX94Nxabfw", "7DgTySDIiLc", "wGy61iFXdNM", "2pa9clNlirw", "aXpQJjAWPUs", "o74a5465rBA", "aXQhW8Vzuvo", "ayoLljgfTkM", "CWyoWoIOLIk", "_0Qjl6UCqvU", "vvkVkVhgiRo", "yeX2Dz5F80M", "8WLAh6ySyeY"};
    String[] s2 = {"KwSmlODnUd0", "KQTE0p27rEw", "Tp3mby-yk_Y", "XPz70HsPnWA", "Ff3BG8qq6cs", "jRm2WFMEORQ", "kHOadxxc9TA", "CJhhEjHlJ-I", "5MGoXkKj_7Y", "MPF_GyHtvOU", "2qGT-GKpUkk", "1Z6hwhI0g8U", "d5idNaiGfzk", "mkVojA3Dz8U", "48MyPJQ-VkY", "4RG3U-vR3Cs", "SA5qhBe4FO8"};
    String[] s3 = {"NKw-2A92TiA", "UzeU_LHTCzQ", "FgAyh0cg7LQ", "RlJAKfqx9jI", "Xd4vI0QREWs", "Sffu3LaRZFM", "WBDxCEa6O20", "19kSxlQWXKo", "SWWr4ByBRbI", "C0wkumSV2DI", "l9FLRKijT8E", "R6_Mbi4VTFE", "warIvWqV7z4", "-lFTHIDsRSw", "Zzomj6Akndw", "P56Qf9OiPik", "a-ZnHIBfUi0", "z0_5FjHiSSg", "EeZw5BhrFDs"};
    String[] s4 = {"zT3Ex7AxOrw", "KYlGcmmMA5A", "PwD29Gbiw68", "HVTctFFRksk", "JueSJZi2AKk", "kFuaVpEkRFY", "r4FBR6PysBI", "DWAbr_SxDwM", "0bz4W4MkYMU", "ZPMu0ewi4cc", "twV_uLI4DAM", "J28WYgJvAHU", "sAUKj3nlRX4", "C14jMNM4FAk", "N20gQEK-Or0", "NHyf5eBzJ_U", "7Ln3zJGemTU", "gkDA3qCoyvM", "fBUHHo_AEPc", "15ekFMoWYQ0", "g4f0BfZeXQo", "CmbjXoPA3yM", "zJPhLs5n6Zo", "HCw88nqRMnM", "DfjAXvpiNUc", "sV0QQ6FVgXk", "jNI6RfMGdfg", "ji3KdGJIT3A", "V-q6yC9vuok", "-Y0eI1jIsAk", "NryORJAS0OE"};
    String[] s5 = {"wJ2O4vPCvdE", "xLEPGJ4bjEs", "DmecZtTrgW8", "RrD0YAlM9fs", "1tiEyfXeZKY", "x3Vj8zQ9zVA", "u72YlGK2jko", "9cBFXdE59GU", "W3WUgEGprCk", "vAUhlH9dbuE", "wqaX85rMKFo", "YG6jVcIKqTQ", "csdDJepv_j8"};
    String[] s6 = {"HyFuW9jVo9w", "_H1poH0q6jg", "VV7-s745Zuc", "8r9DqT6w7xs", "st5_XA2uRDM", "WIdqctbNxSE", "su091748XKY", "UoL-Rke4XaM", "dg9rBB-35Yg", "qgXxfpq-Dow", "RVBj4pEtClM", "gVLfnnhLo1c", "KpG7h1Xd3GU", "mciN57C2wX8", "2uoCGTAWjl0", "Uk9Hl93YcQ4", "vkBZTj_lqYM", "YJLJx0GwuOs", "jmQXiLAdtRM", "ZZXzo6ibUiI", "k3eLkT1e970", "UYFXFCWfB6g", "mKKKDiimH88", "4DGOH1xNXoY", "SQua9qKoMfs", "LZWqaPkvgeY", "UEiLf5bpEQo", "Fr3VdtCS7_k", "_IKXgUIsYcc", "v_dxqiuui9U", "f69CDPR8BHY", "8Ti03NyM6zA", "LVc9wNoy6o0", "s44RQi_P7kQ", "0uCEomzHU2g"};
    String[] s7 = {"5Xlb4lY-LhA", "Eyjr8ggq8YU", "eB8vL6E_uwc", "DFbSsW7-RPs", "3anGASH1Qzs", "flIAlPGzEho", "BhZf9yn_7QI", "_jBdk2Bk-M0", "J82JF3UNyz8", "ECrsVyCNJ5A", "bSRv0C0fprM", "Iw6Ph4P85iw", "2vC96G800pw", "Bf_Dgk9Ywfk", "ij9NwVdR5fg", "DeXt6QnauqU", "S-G4tIOm5LA", "9aWdJX0teCM", "_2q4suUzByc", "ahinGaL9U78", "dST_pLF6pX4", "UTYw-sNTNfw", "eSlBWZJuhII", "P3dFjsQ1rNU", "cBa3UZrfttk", "_8Msi8wZuS0"};
    String[] s8 = {"GZRX_OuyEIQ", "kapHnEw7EgM", "B7yZtR5EnYw", "ZdCwg-oAUsM", "sqJsCnZJLxU", "7wXSPpEUCsU", "JID5SY_QmR4", "zdKqb06_nJ8", "bFx6BXLK5wY", "cV09glldeW8", "JESREoosOvI", "AIzxCwsBuSo", "78kkvMtnNRw", "MsUnoSnWtzI", "J_70m_sHrrI", "MOWswa8pK8s", "tMf5GNzEEjo", "gISMPt7wnek", "jPArGkgziiM", "F1KdGPxESCU", "r3j9opDfNy0", "QgGK9jh85EQ", "EQZUyTymEbs", "ed0prSXSCfY", "HXEm7947ELg", "HI9ZVA-2v58", "nbIXcWA0cbs"};
    String[] s9 = {"Ka8_ZBxayR8", "ihDkk1DIDv4", "PRYr9jCuYlI", "oPtE3D11VIc", "URy1xzErUK8", "gYGPts8PnN0", "rwi7YxEZIGs", "7RBGX2zPAgI", "hXrP47J9ZMg", "-lZe4You9JA", "6ncwtfVw2ag", "2Zpmyp7ovxM", "dELTnYUdEEI", "fx4J1bEkYXs", "ulnni1B3uOQ", "v23wCCUQ9fA", "9laDSrj9TM8", "z3uJsv6Ls4s", "vineMHHCFcQ", "1z8PjOqx8lk", "wQU6Dfm2QOI"};
    String[] s10 = {"c4CqYGpceGY", "IVseTUTtZWA", "41JCQV6mA78", "HuyEnOZp7XY", "m-21BHddGu0", "R-rPGtLjxlQ", "v0sXOq9k6P0", "k4Nr4_i-wh0", "3-VP9j6RqKA", "W3JE0OhAZqA", "P9tPk5jCchQ", "AqXjuRie6mY", "0KC8YB_X5ww", "DuaXfkw3wGU", "ChOW-cdHqv4", "_86PsrjubrU", "_AQI17fXPKo", "EWJthSa_6u4", "Nn_PxgYFRIA", "KKvRLDa-dv8", "RMfuREalTWM", "QOM-J22AM7I", "Csv4Wi2a1lQ"};
    String[] s11 = {"XOWC3LU8y04", "EmhHGFLXQXM", "b_g7vesAvhI", "ANwj-6KVqoM", "C4h5IFs_dMM", "JsaUCH6f5pU", "G4YX6xNNXDc", "rMQli-Gmz2w", "KIAxm1UEOGc", "F0WBGw3fims", "pGnPDXWyN-o"};
    String[] s12 = {"caJMuENuFTM", "0AaCcJ_j4mw", "phg401i2GQI", "yo-pwfYD7qQ", "VpAp9_0wBNs", "6xyg1Ohu7BE", "jEmMTUyUKsA", "7w7MiieTPjk", "JIwGgQrK684", "oCQeF7WRNgs", "RmbPYHWxDZk", "zqapY8PSB6M", "sWd5dd8RG_A", "7YrjrHAwqcM"};
    String[] s13 = {"5xuXCCmVkfk", "3lusVaE4Gx0", "ETJWrsJtN9I", "Dm686nrNnfc", "mpOg-qGwHiM", "8hFWFtFBFpM", "lahQXNvZxt8", "GkD8RMEXi6s", "IGfO7MKVxmg", "6szLmpJW2Fc", "17ePwh-bg_4", "YddV_FkCKYM", "q5L8kZS7KbM", "KsEn2YbvHko"};
    String[] s14 = {"qcqDu4DlJUQ", "0HoMKxQiY6E", "ng62oFC0mQc", "TiWruMgUpjw", "lWlY1FNfYY0", "MAfZ2yN-9jw", "QzHinheLn7w", "nx61viLYbVQ", "6cGIF3zCTjg", "0nCtj964Jrs", "rPE2M9L2uQ0", "unGeS_V0hpE", "pq4P9Vafhlo", "nNgGKLILsbU", "Xg9RLJzUcLQ", "P5S0SJpnQWU"};
    String[] s15 = {"5vY4g6c3ENo", "nogRebV6zXw", "-Wp1SWQKB4c", "wuGwIus8mSw", "y3Z9PAzV1aI", "X1NLtRjS09o", "gPZJMcKROZE", "nM8XKHtK5Io", "aqtXBVld85I", "Wsh2O2Xe1G0", "UDRdd_xnKJI", "7U4nZ8nH_UY", "BGXTy3na8so", "qFwVvmLG3LA", "mGw3qaYHViI", "AMzw37DAaGc"};
    String[] s16 = {"ABTGr0zVeoA", "mOqkSWZFCuQ", "h1hOK_-iuYk", "qcn64Bn68YM", "wCB1xvq8MKs", "fCNVdryR-H8", "u2DiDXI5N0E", "7xGthQny5Jo"};
    String[][] Sciencevideos = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16};

    String[] ss1 = {"0aAH9Xljvns", "3Hx9BxucVec", "N1hSrcwCEQU", "Rq9in2DtHg0", "gR2wzzZi9Uo", "YGBYK9CqKkk"};
    String[] ss2 = {"hmSyvs4Zm4U", "uA79iEe104c", "vaiEnuKl4lA", "v_MXbpfoSmA", "Dy87QWw05E4", "f1_kmTNaRQg", "4BeOr0c06s4"};
    String[] ss3 = {"9ByzzzDjlHw", "_3paq8xnldE", "OYElgrYvH4Y", "SXDRIcsX5G0"};
    String[] ss4 = {"3iOXlF_2npI", "0f-VMlFgxUI", "VTpCWm3vK3o", "IH6vJmwTHew", "N0AEIg4P8Ns", "vm9_lToZ46w"};
    String[] ss5 = {"9GtNbFEQMBY", "csP7t5mS3ME", "h1mTIVZVzD4", "mXoeFl67ihs", "7WngOXzdwk0", "4nHp-iJ5UJY", "rRYAZFp-AMk"};
    String[] ss6 = {"Zb7aLb1-9Y0", "VKhzlUM_OsE", "b2baRjr8vUc", "vs1UiW6g0UY", "7NnkCSQpEoI", "GhmoBSWei-M", "oKUkCgjjAZs", "gLotr-0GGMk", "jPpauRL2x1k", "KyDrmTaC7Lw"};
    String[] ss7 = {"46JXMpQXk10", "dRvay4MjoRY", "ZphxjwxTVQA", "jNs9GCIOVZU", "lBCgSg_sDz4", "EW4oXoGcOuQ", "tMA2YVfGhU4"};
    String[] ss8 = {"bdEE3g9uw3g", "GinoHD5r4Nk", "946Kh_P78dk", "hXRrCE_bSL0", "rYV0u62URps", "aa6JsKFdVYQ", "2D2KxSu9DN4", "upgQVdf47dE", "sZVGxxQcpME", "ji7NelOTCzc"};
    String[] ss9 = {"1yX4pWbn1Iw", "OyTpHiPDlFg", "QqYIv6S95vw", "JvFQwx5BVVg", "46qbNhCX1yM", "df7h8-k7a_Y", "6-Zr0bFvEkM", "VYATexItwzI", "efxbjKlgMGw", "PLd2LFfsXDs", "DSo771Sn5Ik"};
    String[] ss10 = {"kdRS6l19i8E", "hhQg0dSAmGE", "q-OC5b6k6cc", "42E0792pnqA"};
    String[] ss11 = {"JOh9fscUgSI", "W3yyjOSEO2E", "tj1h-PtMNPo", "p8QQ3TrVKbo", "xySF_7mWu5A", "uz7H3iRerLE", "6MzS5G4_rKs"};
    String[] ss12 = {"j3N7HlGGxO8", "lFnOmGrPNLo", "I-VBJ30NlmA", "jcytUUk964c", "2XRok6iia2E", "azDqVySDe2A", "5zk9yar9sA4"};
    String[] ss13 = {"b6zzPeS6Ne8", "3_c03t9guGI", "UOWhXZAbVTg", "Vs95KsOFIYI", "jCBypjR2K6c", "pdjGjvt3vBY", "pfdzl-5KKJ4", "9hSYurMgaIc", "D3_Wm4LZOvw", "K4TEuJsUGEM"};
    String[] ss14 = {"N8fuNEl5fAs", "cKfuPN0zzKQ", "m9kACSod_k0", "xa5zj5IvUrY", "9103W792y-8", "Fo0BocvoQBo", "ktw0JvDxWEQ", "46Z7qGDLllE"};
    String[] ss15 = {"oLvzueDnbHo", "xURUuFGc7Vc", "i4TXZLCpukk", "1U1emmTR03w"};
    String[] ss16 = {"7JUDgKnENEo", "_27mdE-wRSI", "E18W1JOgtBQ", "uW_RQuXj31k"};
    String[] ss17 = {"Cz0LWL4ru6o", "xwlOTj1W3O4", "ANlmmplJJtw", "MYaxA1tKBco"};
    String[] ss18 = {"PEvJCZeyWqA", "-rgRYoJ5Lt4", "b-CfGvfRQOs", "zDgDaWd1YbI", "jXYeA0p5J1U"};
    String[] ss19 = {"ayuI0VODQ38", "6vz80qn2jyU", "V-ZZstCB6eM", "WOmLLJ_0yko", "LQYU_0M7gvY", "AMg-BnUJR_o", "cMBZazRsxCU"};
    String[] ss20 = {"ayuI0VODQ38", "6vz80qn2jyU", "V-ZZstCB6eM", "WOmLLJ_0yko", "LQYU_0M7gvY", "AMg-BnUJR_o", "cMBZazRsxCU"};
    String[] ss21 = {"Ov72bimQJc0", "Gtj8GGec8Hs", "LX8L3JgRSUo", "_500I9T4OFM"};
    String[] ss22 = {"DGZUo3uXszk", "h88NNyXeEds", "kE7deC6pK34", "gkUa1Q7TyUk"};
    String[] ss23 = {"zo-VF8zH9eM", "g0jTWrgi3Ow", "pxfXyUz6qIc", "SsQksmZRQtI", "f9h65PSIf7M", "4T3R0zVTy-c"};
    String[] ss24 = {"jxgVI9Mur-M", "Lx4Z58Crfns", "-WGVv7fmUcc", "RMbt7b7C8gc", "aazcpMeEg84"};
    String[] ss25 = {"eYnhFY0bLLU", "FBikLMdEbaY", "OQDzp6Njip0", "jsCJOEAIsLc", "Y92lQLciTbQ", "-RFHCmCJbqM"};
    String[] ss26 = {"MZtfrAp-t4w", "dhPJVg_atVA", "Y9Zbes3I1no", "-J95cAI_OkY", "QDBehvdUINg", "767DDsP3Szw"};
    String[] ss27 = {"iO4eT4wa3zI", "RvA5HzArSa0", "RSkogtZCy6g", "gDW9xmrZjI4"};
    String[][] Socialvideos = {ss1, ss2, ss3, ss4, ss5, ss6, ss7, ss8, ss9, ss10, ss11, ss12, ss13, ss14, ss15, ss16, ss17, ss18, ss19, ss20, ss21, ss22, ss23, ss24, ss25, ss26, ss27};

    String[] ea1 = {"kPicfM5ob5M", "_VHnT3U9bos", "vEnNl9bFN2g"};
    String[] ea2 = {"n6_Gg_1riow", "ep5iCvu4d4Y", "lsM6BqpsIOw", "-wsGRyVY-0U"};
    String[] ea3 = {"cmD3PQfPBOU", "_uIw4oFiQb8"};
    String[] ea4 = {"k4PeUWd3TG8", "DudYV8yURWE", "HbGR3eW32k8"};
    String[] ea5 = {"t0KWmwHIrbE", "CzQZHClYpW8"};
    String[] ea6 = {"o3i18GKJeJc", "XjVEncDDkLo", "TCStRVeiwng", "wYiIORvwC3c", "TQZHZpV3nPU", "yo8GQMMMecU", "nLHvLD5fnkg", "ub3mjsCSAZs"};
    String[] ea7 = {"rRRj3J6ip40", "F1X-grsH018"};
    String[] ea8 = {"hstcw_kv-AM", "arffRB8Qte8", "Q1d6qj6U_Xs", "ysIoP-k6j_I"};
    String[] ea9 = {"qUwpOHBXh_M", "196uBAqAnKI", "CXAw6SUAupY"};
    String[] ea10 = {"epPf1nzVAvA", "roQ7CWY37u8", "hSWdVsUY6Fs", "vBEC8Fhe4yo"};
    String[] ea11 = {"CXEQLH2m2j4", "vlQw9ahpN10", "FTVNqcaF8yk"};
    String[] ea12 = {"Y9d7IQe-Tt4", "TMPB-Wu-ETo", "Ril0Vk4oXyU"};
    String[] ea13 = {"IBoHs-zlUPI", "ilDQD72PACM", "DdOTiajtsMY", "PvPrM1-J4fQ"};
    String[] ea14 = {"4EHfL_XCMNw", "l4RnhKEpd-g", "PvPrM1-J4fQ"};
    String[] ea15 = {"noTxjqqtzrw", "6IHi4qxkfLI", "sE6NRcqGqdA"};
    String[] ea16 = {"c6YQvQsMSOI", "LFx1fxit6Es", "YbDRdG5dG6U", "_BSs5aUaYoU", "7Iu63RbV8l4"};
    String[] ea17 = {"uoILeRJPcE8", "nqlZotykx_4", "1m94RwjVHEQ"};
    String[] ea18 = {"NuhrBVwKj68", "xaEfwe5QkYU", "SZAgU7x0GfY"};
    String[] ea19 = {"C9AAgGVlH64", "kO9tbZecdCA", "IdzUAkyI3zI"};
    String[] ea20 = {"czKcX88PG9k", "XArEYvfO9qc", "0hnCRD4fiwE", "DqxPgjdHrQk"};
    String[] ea21 = {"lBTze9OvQ40", "HnzaVgLdItI", "61kQiXFrBuU"};
    String[] ea22 = {"CKUfBh4O6bo", "_HXUgHnfmMY", "AyhT01Oww9U", "gXO4TVK7C-k"};
    String[] ea23 = {"ZcmNWNGPNNU", "I3IU7zY5lJg", "PZeGsWwOd5M"};
    String[] ea24 = {"kZJw1fgvKS0", "5pwtEg9urrk", "1StcEs-w3I0", "0pSN2GD28A8", "bDm8cqVK1xQ", "vX_jEhgWTcA", "Domhxp3HZ-M", "DL0_p22PsHg", "26uqr6pWxnw", "04TKN4SN4Zk", "ciO5x5hwteM", "3GFuCmtIEGk", "ffGAA74n3PE", "OgloaAa6I0c", "vSAyb9DZUdU", "brKT_xORnuA", "77X_pxocIJk", "QnNBhJvlVO4", "yODM6irkjr0", "b5GyFKeUVDA", "fdIWgYnLKGs", "fNrRWo9slGQ", "9vxNNtGYG3E", "p4WfzCWaN5I", "1AqZ5zsoLEI", "FnOtmHy8r9k", "aq-LoQUZ8P4", "kunjee67beo"};
    String[] ea25 = {"OHCJKfNQFyU", "KbQ8pRpKQYI", "eh14_3YCyLE", "j_A2AUnDDoo", "cS-Ex9urirc", "LXlldCu0ul4", "9PzY5oor4g4", "zk-8lMp5TD0", "9q0tZFwR1Ek", "rOQvtQzszpA", "nWGS2T3ygoY", "5E0l5fV4nVA", "XvVDM8-GPiA", "WAjm2PjOtPc", "tjJDUoO8R8M", "IUzogWCaeP0"};
    String[][] EnglishAvideos = {ea1, ea2, ea3, ea4, ea5, ea6, ea7, ea8, ea9, ea10, ea11, ea12, ea13, ea14, ea15, ea16, ea17, ea18, ea19, ea20, ea21, ea22, ea23, ea24, ea25};

    String[] eb1 = ea1;
    String[] eb2 = ea2;
    String[] eb3 = ea4;
    String[] eb4 = ea3;
    String[] eb5 = ea5;
    String[] eb6 = ea6;
    String[] eb7 = ea7;
    String[] eb8 = ea8;
    String[] eb9 = ea9;
    String[] eb10 = {"R5RqEhl6aTc", "WD3oRrkU6LU", "QyROEDSdcwQ"};
    String[] eb11 = {"bRY-t_--Zl4", "680pe6qZsig"};
    String[] eb12 = {"enSKwhZTkUo"};
    String[] eb13 = {"mKY50HXKg6Y"};
    String[] eb14 = {"igpbPT9uo3M"};
    String[] eb15 = {"RCDtGZHXlps"};
    String[] eb16 = {"VFlcx7AaTes", "jFHIdlKVwnQ"};
    String[] eb17 = {"9GARipOyVnE", "6I3gS7mHBJ4", "MCIXBtaOe68", "MGnt0At34Uk"};
    String[] eb18 = {"39NV90Ddyfs"};
    String[] eb19 = {"_W4wwVepN7I", "IQil50Gm0KI", "PnCv7HgniiE"};
    String[] eb20 = {"vLWHWXGHEOw", "ONMdclVWMwY", "_9VpUrJt058"};
    String[] eb21 = {"ieK2nocK5zk"};
    String[] eb22 = {"64rVDDYL180"};
    String[] eb23 = {"GOxbNiFc914", "yISx-pSR4sg"};
    String[] eb24 = {"h4RfAfpSaTg"};
    String[] eb25 = {"Jip0hwLy3qI"};
    String[] eb26 = {"7mL4j2JsvcE"};
    String[] eb27 = {"3zWDedDI_RI"};
    String[] eb28 = {"oERO7FqnIsc"};
    String[] eb29 = {"rhJlfMJ5ETk", "4iUe4k9NByo"};
    String[] eb30 = {"_Ei-E4oDuBY"};
    String[] eb31 = {"HtJLI8V019U"};
    String[] eb32 = {"UKsO1_zYZ0A"};
    String[] eb33 = {"kp3bEbzOdKc"};
    String[] eb34 = {"ftFaBQACup8"};
    String[] eb35 = {"gU3qsQ-6Ygo"};
    String[] eb36 = {"1H96pAppo6I"};
    String[] eb37 = {"ut_XpFNvEpQ"};
    String[] eb38 = {"eCtFTUQRF-4"};
    String[] eb39 = ea24;
    String[] eb40 = ea25;
    String[][] EnglishBvideos = {eb1, eb2, eb3, eb4, eb5, eb6, eb7, eb8, eb9, eb10, eb11, eb12, eb13, eb14, eb15, eb16, eb17, eb18, eb19, eb20, eb21, eb22, eb23, eb24, eb25, eb26, eb27, eb28, eb29, eb30, eb31, eb32, eb33, eb34, eb35, eb36, eb37, eb38, eb39, eb40};

    String[] ha1 = {"sDr7H2ioXmw", "_JbsKr_lN-A", "cm4DXns9Jzg"};
    String[] ha2 = {"mY7mqEgl-V0", "sDr7H2ioXmw", "_JbsKr_lN-A"};
    String[] ha3 = {"FnVtY4YeXhg", "5kPUSBTbkQ4", "Pbr143XEjDM"};
    String[] ha4 = {"3WAic_iEPTI", "Yidp95_4bQo", "4koVY14vHeQ", "6xrOchxV9HU"};
    String[] ha5 = {"Lk5fiLtHZOs", "LNThQ4DD1WE", "4jYfoR1eoY8"};
    String[] ha6 = {"URv2PU9Lddc", "bMaamcbxJTo"};
    String[] ha7 = {"Ou2JAn285c8", "eFNM6y_cpjY"};
    String[] ha8 = {"IcODpodl3IA", "35tEjfTD-9A", "6yvjdZ_20lQ"};
    String[] ha9 = {"2w-n88Tjk58", "avfgyriA9x4"};
    String[] ha10 = {"0kWdVxBKC4k"};
    String[] ha11 = {"zySlsYrkfXk"};
    String[] ha12 = {"Mb-eWHRpqXc"};
    String[] ha13 = {"DmC3mHpjJzI"};
    String[] ha14 = {"w7FDYur5e4U", "8igvyXziJuI"};
    String[] ha15 = {"jxl9XT-cU1M", "5SIdAUYOU9s"};
    String[] ha16 = {"efiwPLDfhiM"};
    String[] ha17 = {"ErWbepc8NCs"};
    String[] ha18 = {"_WRbR11HVvY"};
    String[] ha19 = {"-MIBGxePZLE"};
    String[] ha20 = {"ASeKUK1hQdc"};
    String[] ha21 = {"5b1ONz7gJWs"};
    String[] ha22 = {"0rdKs65s_4g"};
    String[] ha23 = {"oNkASWeKNzI", "LLLSzt1eaUs"};
    String[] ha24 = {"kQyeGSsXeVk"};
    String[] ha25 = {"ReySD60wV9I", "tbyk7aVOJqM"};
    String[] ha26 = {"_zAmWKuFaoI"};
    String[] ha27 = {"dkou7Arr8FY"};
    String[] ha28 = {"vf8yEIUic6w"};
    String[] ha29 = {"TSaI0de6IuI", "lm93JLj3Iyo"};
    String[] ha30 = {"rcmL0NSCMLo"};
    String[] ha31 = {"YZnnOXiRNjA"};
    String[][] HindiAvideos = {ha1, ha2, ha3, ha4, ha5, ha6, ha7, ha8, ha9, ha10, ha11, ha12, ha13, ha14, ha15, ha16, ha17, ha18, ha19, ha20, ha21, ha22, ha23, ha24, ha25, ha26, ha27, ha28, ha29, ha30, ha31};

    String[] hb1 = {"Tkh5CZJ4j3E", "EHAupKXF7AM"};
    String[] hb2 = ha8;
    String[] hb3 = {"uMtC9_3rPag", "59PjpuMVdGY"};
    String[] hb4 = {"YMD_Si8o6EE", "30q2nLI6Low"};
    String[] hb5 = {"2w-n88Tjk58", "avfgyriA9x4"};
    String[] hb6 = {"va9gcZeGAHs", "sQWkoo87fV4"};
    String[] hb7 = {"XZ3uj09WBoc", "kJoivM6Klds"};
    String[] hb8 = {"wg8Qy4t3--0", "id9GziSBzJo"};
    String[] hb9 = {"Te4gwz5vPwU", "qapIHgqN-RQ"};
    String[] hb10 = {"2Ffl0ho_w8s", "pZo55HTdoa8", "T8u90EL4Xnk"};
    String[] hb11 = {"-COVEF-8PrY", "FmK5pu_gn5c", "9yCV6y47bBc"};
    String[] hb12 = {"qr6KXt7LpB4", "Ws-a6Y3HPjQ", "CnZq5JBWgGg"};
    String[] hb13 = {"ot46P7XvJFs", "TV6EtJBH34k", "Q5FMPbmbZX8"};
    String[] hb14 = {"OlK6szeQpCM", "Gg0m344yxnc", "7KzZP3uwpj4"};
    String[] hb15 = {"R50n2fm8ClA", "0JGhQmdC17k", "k2viDPOog1o"};
    String[] hb16 = {"ZMCIaDXjuww", "_b5dU6FXIvE", "IMbRwbomA3A"};
    String[] hb17 = {"caqsczW8UH0", "jmF4KcAt_iU", "MKMOUDoZUs4"};
    String[] hb18 = {"nCYx6kr7wFM", "tks2UN3XmdI"};
    String[] hb19 = {"jLMdVUUfn7I", "lcDZsdencyQ"};
    String[] hb20 = {"eXkzH-wmlgs", "rZukY0qql78", "5i0tX5QbCbk"};
    String[] hb21 = {"hXSD0GU3tpQ", "Tn0YaXYLFy0", "QLdlmtTPNN0"};
    String[] hb22 = {"SnjWPznX8QU", "i_XgwzlQ5ho", "AYMbTAPCHpY"};
    String[] hb23 = {"4BqQjIDHn2w", "HJLOpRPwY64", "4_TakzK7aUU"};
    String[] hb24 = {"fya786VkYeI", "iF-Hy9ZNejE", "biYrWkmxFgs", "5v3gixaNsV0"};
    String[] hb25 = {"r38aKHKe7Uw", "z57S5Fntv-c", "TiKYXCoeV4I"};
    String[][] HindiBvideos = {hb1, hb2, hb3, hb4, hb5, hb6, hb7, hb8, hb9, hb10, hb11, hb12, hb13, hb14, hb15, hb16, hb17, hb18, hb19, hb20, hb21, hb22, hb23, hb24, hb25};


    Integer subject_selected;
    Integer chapter_position;
    ArrayList<String> thumblainlist;
    ArrayList<String> titlelist;
    Toolbar toolbar;


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
        setContentView(R.layout.activity_video_list);

        AppController.getInstance().showinterstitialad(VideoListActivity.this);

        String title = getIntent().getStringExtra("title");
        subject_selected = getIntent().getIntExtra("subject_position", 0);
        chapter_position = getIntent().getIntExtra("content_position", 0);


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


        



        AppController application = (AppController) this.getApplication();
        Tracker mTracker = application.getDefaultTracker();
        mTracker.setScreenName("screen name:" + "VideoListActivity");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());

        // Obtain the FirebaseAnalytics instance.
        FirebaseAnalytics mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "VideoListActivity");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "VideoListActivity");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        if (title != null) {
            getSupportActionBar().setTitle(title);
        }

        gv = (GridView) findViewById(R.id.grid_view);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        new HeavyWorker(this).execute();

    }

    public class HeavyWorker extends AsyncTask<String, Context, Void> {

        private ProgressDialog progressDialog;
        private Context targetCtx;
        private boolean needToShow;

        public HeavyWorker(Context context) {
            this.targetCtx = context;
            this.needToShow = true;
            progressDialog = new ProgressDialog(targetCtx);
            progressDialog.setCancelable(false);
            progressDialog.setMessage("Retrieving Videos...");
            progressDialog.setTitle("Please wait");
            progressDialog.setIndeterminate(true);
        }

        @Override
        protected void onPreExecute() {
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(String... params) {
            // Do Your WORK here
            if (subject_selected == 0) {
                thumblainlist = new ArrayList<>();
                titlelist = new ArrayList<>();
                for (int i = 0; i < Mathsvideos[chapter_position].length; i++) {
                    String titleofvideo = SimpleYouTubeHelper.getTitleQuietly("" + Mathsvideos[chapter_position][i]);
                 //   String thumblain = SimpleYouTubeHelper.getThumblain("" + Mathsvideos[chapter_position][i]);
                    titlelist.add(titleofvideo);
                    String url = "https://img.youtube.com/vi/"+Mathsvideos[chapter_position][i]+"/0.jpg";
                    thumblainlist.add(url);
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        gv.setAdapter(new VideoAdapter(VideoListActivity.this, thumblainlist, titlelist));
                    }
                });
                gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intent = new Intent(VideoListActivity.this, PlayVideoActivity.class);
                        intent.putExtra("videoobjects", Mathsvideos[chapter_position][position]);
                        intent.putExtra("videotitle", titlelist.get(position));
                        startActivity(intent);
                    }
                });
            } else if (subject_selected == 1) {
                thumblainlist = new ArrayList<>();
                titlelist = new ArrayList<>();
                for (int i = 0; i < Sciencevideos[chapter_position].length; i++) {
                    String titleofvideo = SimpleYouTubeHelper.getTitleQuietly("" + Sciencevideos[chapter_position][i]);
                  //  String thumblain = SimpleYouTubeHelper.getThumblain("" + Sciencevideos[chapter_position][i]);
                    String url = "https://img.youtube.com/vi/"+Sciencevideos[chapter_position][i]+"/0.jpg";
                    titlelist.add(titleofvideo);
                    thumblainlist.add(url);
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        gv.setAdapter(new VideoAdapter(VideoListActivity.this, thumblainlist, titlelist));
                    }
                });
                gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intent = new Intent(VideoListActivity.this, PlayVideoActivity.class);
                        intent.putExtra("videoobjects", Sciencevideos[chapter_position][position]);
                        intent.putExtra("videotitle", titlelist.get(position));
                        startActivity(intent);
                    }
                });
            } else if (subject_selected == 2) {
                thumblainlist = new ArrayList<>();
                titlelist = new ArrayList<>();
                for (int i = 0; i < Socialvideos[chapter_position].length; i++) {
                    String titleofvideo = SimpleYouTubeHelper.getTitleQuietly("" + Socialvideos[chapter_position][i]);
                  //  String thumblain = SimpleYouTubeHelper.getThumblain("" + Socialvideos[chapter_position][i]);
                    String url = "https://img.youtube.com/vi/"+Socialvideos[chapter_position][i]+"/0.jpg";
                    titlelist.add(titleofvideo);
                    thumblainlist.add(url);
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        gv.setAdapter(new VideoAdapter(VideoListActivity.this, thumblainlist, titlelist));
                    }
                });
                gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intent = new Intent(VideoListActivity.this, PlayVideoActivity.class);
                        intent.putExtra("videoobjects", Socialvideos[chapter_position][position]);
                        intent.putExtra("videotitle", titlelist.get(position));
                        startActivity(intent);
                    }
                });
            }else if (subject_selected == 3) {
                thumblainlist = new ArrayList<>();
                titlelist = new ArrayList<>();
                for (int i = 0; i < EnglishAvideos[chapter_position].length; i++) {
                    String titleofvideo = SimpleYouTubeHelper.getTitleQuietly("" + EnglishAvideos[chapter_position][i]);
                 //   String thumblain = SimpleYouTubeHelper.getThumblain("" + EnglishAvideos[chapter_position][i]);
                    String url = "https://img.youtube.com/vi/"+EnglishAvideos[chapter_position][i]+"/0.jpg";
                    titlelist.add(titleofvideo);
                    thumblainlist.add(url);
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        gv.setAdapter(new VideoAdapter(VideoListActivity.this, thumblainlist, titlelist));
                    }
                });
                gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intent = new Intent(VideoListActivity.this, PlayVideoActivity.class);
                        intent.putExtra("videoobjects", EnglishAvideos[chapter_position][position]);
                        intent.putExtra("videotitle", titlelist.get(position));
                        startActivity(intent);
                    }
                });
            }
            else if (subject_selected == 4) {
                thumblainlist = new ArrayList<>();
                titlelist = new ArrayList<>();
                for (int i = 0; i < EnglishBvideos[chapter_position].length; i++) {
                    String titleofvideo = SimpleYouTubeHelper.getTitleQuietly("" + EnglishBvideos[chapter_position][i]);
                  //  String thumblain = SimpleYouTubeHelper.getThumblain("" + EnglishBvideos[chapter_position][i]);
                    String url = "https://img.youtube.com/vi/"+EnglishBvideos[chapter_position][i]+"/0.jpg";
                    titlelist.add(titleofvideo);
                    thumblainlist.add(url);
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        gv.setAdapter(new VideoAdapter(VideoListActivity.this, thumblainlist, titlelist));
                    }
                });
                gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intent = new Intent(VideoListActivity.this, PlayVideoActivity.class);
                        intent.putExtra("videoobjects", EnglishBvideos[chapter_position][position]);
                        intent.putExtra("videotitle", titlelist.get(position));
                        startActivity(intent);
                    }
                });
            }
            else if (subject_selected == 5) {
                thumblainlist = new ArrayList<>();
                titlelist = new ArrayList<>();
                for (int i = 0; i < HindiAvideos[chapter_position].length; i++) {
                    String titleofvideo = SimpleYouTubeHelper.getTitleQuietly("" + HindiAvideos[chapter_position][i]);
                  //  String thumblain = SimpleYouTubeHelper.getThumblain("" + HindiAvideos[chapter_position][i]);
                    String url = "https://img.youtube.com/vi/"+ HindiAvideos[chapter_position][i] +"/0.jpg";
                    titlelist.add(titleofvideo);
                    thumblainlist.add(url);
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        gv.setAdapter(new VideoAdapter(VideoListActivity.this, thumblainlist, titlelist));
                    }
                });
                gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intent = new Intent(VideoListActivity.this, PlayVideoActivity.class);
                        intent.putExtra("videoobjects", HindiAvideos[chapter_position][position]);
                        intent.putExtra("videotitle", titlelist.get(position));
                        startActivity(intent);
                    }
                });
            }
            else if (subject_selected == 6) {
                thumblainlist = new ArrayList<>();
                titlelist = new ArrayList<>();
                for (int i = 0; i < HindiBvideos[chapter_position].length; i++) {
                    String titleofvideo = SimpleYouTubeHelper.getTitleQuietly("" + HindiBvideos[chapter_position][i]);
                  //  String thumblain = SimpleYouTubeHelper.getThumblain("" + HindiBvideos[chapter_position][i]);
                    String url = "https://img.youtube.com/vi/"+ HindiBvideos[chapter_position][i] +"/0.jpg";
                    titlelist.add(titleofvideo);
                    thumblainlist.add(url);
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        gv.setAdapter(new VideoAdapter(VideoListActivity.this, thumblainlist, titlelist));
                    }
                });
                gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intent = new Intent(VideoListActivity.this, PlayVideoActivity.class);
                        intent.putExtra("videoobjects", HindiBvideos[chapter_position][position]);
                        intent.putExtra("videotitle", titlelist.get(position));
                        startActivity(intent);
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }
    }
}


