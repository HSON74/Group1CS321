package org.openjfx.Workflow;

public class Helper {
    public static String intToMonth(int i) {
        switch (i) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return null;
        }
    }

    public static int monthToInt(String i) {
        switch (i) {
            case "January":
                return 1;
            case "Jan":
                return 1;
            case "February":
                return 2;
            case "Feb":
                return 2;
            case "March":
                return 3;
            case "Mar":
                return 3;
            case "April":
                return 4;
            case "Apr":
                return 4;
            case "May":
                return 5;
            case "June":
                return 6;
            case "Jun":
                return 6;
            case "July":
                return 7;
            case "Jul":
                return 7;
            case "August":
                return 8;
            case "Aug":
                return 8;
            case "September":
                return 9;
            case "Sept":
                return 9;
            case "October":
                return 10;
            case "Oct":
                return 10;
            case "November":
                return 11;
            case "Nov":
                return 11;
            case "December":
                return 12;
            case "Dec":
                return 12;
            default:
                return -1;
        }
    }

    public static String intToDay(int nMonth, int nDay, int nYear) {
        if (nMonth == 1) {
            if (nMonth <= 31 && nMonth > 0) {
                return ("" + nDay);
            }
        } else if (nMonth == 2) {
            if (nYear % 4 == 0 && (nMonth <= 29 && nMonth > 0)) {
                return ("" + nDay);
            }
            if (nMonth <= 28 && nMonth > 0) {
                return ("" + nDay);
            }
        } else if (nMonth == 3) {
            if (nMonth <= 31 && nMonth > 0) {
                return ("" + nDay);
            }
        } else if (nMonth == 4) {
            if (nMonth <= 30 && nMonth > 0) {
                return ("" + nDay);
            }
        } else if (nMonth == 5) {
            if (nMonth <= 31 && nMonth > 0) {
                return ("" + nDay);
            }
        } else if (nMonth == 6) {
            if (nMonth <= 30 && nMonth > 0) {
                return ("" + nDay);
            }
        } else if (nMonth == 7) {
            if (nMonth <= 31 && nMonth > 0) {
                return ("" + nDay);
            }
        } else if (nMonth == 8) {
            if (nMonth <= 31 && nMonth > 0) {
                return ("" + nDay);
            }
        } else if (nMonth == 9) {
            if (nMonth <= 30 && nMonth > 0) {
                return ("" + nDay);
            }
        } else if (nMonth == 10) {
            if (nMonth <= 31 && nMonth > 0) {
                return ("" + nDay);
            }
        } else if (nMonth == 11) {
            if (nMonth <= 30 && nMonth > 0) {
                return ("" + nDay);
            }
        } else if (nMonth == 12) {
            if (nMonth <= 31 && nMonth > 0) {
                return ("" + nDay);
            }
        } else {
            return "wrong day for nMonth and year";
        }
        return "wrong day for nMonth and year";
    }

    public static String intToYear(int nYear) {
        return "" + nYear;
    }

    public static Boolean yntoBoolean(String yn) {
        if (yn.equalsIgnoreCase("Yes") || yn.equalsIgnoreCase("True")) {
            return true;
        } else if (yn.equalsIgnoreCase("No") || yn.equalsIgnoreCase("False")) {
            return false;
        }
        return null;
    }

    public static String BooleantoYN(Boolean bol) {
        if (Boolean.TRUE.equals(bol)) {
            return "Yes";
        } else if (Boolean.FALSE.equals(bol)) {
            return "No";
        } else {
            return null;
        }
    }

    public static String BooleantoTF(Boolean bol) {
        if (Boolean.TRUE.equals(bol)) {
            return "True";
        } else if (Boolean.FALSE.equals(bol)) {
            return "False";
        } else {
            return null;
        }
    }

    public static String nullStringCheck(String myString) {
        if (myString == null || myString.equalsIgnoreCase("null") || myString.equalsIgnoreCase("N/A")) {
            return "N/A";
        } else {
            return myString;
        }
    }

    public static String nullStringNullString(String myString) {
        if (myString == null || myString.equalsIgnoreCase("null") || myString.equalsIgnoreCase("N/A")) {
            return "null";
        } else {
            return myString;
        }
    }

    public static String nullStringNull(String myString) {
        if (myString == null || myString.equalsIgnoreCase("null") || myString.equalsIgnoreCase("N/A")) {
            return null;
        } else {
            return myString;
        }
    }
}
