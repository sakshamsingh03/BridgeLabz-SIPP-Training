class DayOfWeek {
    public static void main(String[] args) {
        
        int m = Integer.parseInt(args[0]);  // Month
        int d = Integer.parseInt(args[1]);  // Day
        int y = Integer.parseInt(args[2]);  // Year

        int yo = y - (14 - m) / 12;
        int x = yo + yo / 4 - yo / 100 + yo / 400;
        int mo = m + 12 * ((14 - m) / 12) - 2;
        int dow = (d + x + (31 * mo) / 12) % 7;

        System.out.println("Day of the week is: " + dow);
    }
}
