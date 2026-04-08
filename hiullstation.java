class HillPlace {
    void showFood() {
        System.out.println("Common hill station dishes");
    }

    void showAttraction() {
        System.out.println("Common hill station attractions");
    }

    public static void main(String[] args) {
        HillPlace place;

        place = new ManaliPlace();
        place.showFood();
        place.showAttraction();

        place = new DarjeelingPlace();
        place.showFood();
        place.showAttraction();

        place = new OotyPlace();
        place.showFood();
        place.showAttraction();
    }
}

class ManaliPlace extends HillPlace {
    void showFood() {
        System.out.println("Manali Special: Siddu and Babru");
    }

    void showAttraction() {
        System.out.println("Manali Known For: Snow and adventure activities");
    }
}

class DarjeelingPlace extends HillPlace {
    void showFood() {
        System.out.println("Darjeeling Special: Momos and Thukpa");
    }

    void showAttraction() {
        System.out.println("Darjeeling Known For: Tea gardens and sunrise view");
    }
}

class OotyPlace extends HillPlace {
    void showFood() {
        System.out.println("Ooty Special: Varkey and homemade chocolates");
    }

    void showAttraction() {
        System.out.println("Ooty Known For: Nilgiri hills and toy train ride");
    }
}
