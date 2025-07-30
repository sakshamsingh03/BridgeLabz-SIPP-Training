import java.util.List;

interface MealPlan {
    String getMealType();
    List<String> getMeals();
}

class MealPlanner {
    public static <T extends MealPlan> Meal<T> generateMealPlan(T mealPlan) {
        // Add additional validations here if needed
        System.out.println("Generating personalized plan for: " + mealPlan.getMealType());
        return new Meal<>(mealPlan);
    }
}

import java.util.List;

class VeganMeal implements MealPlan {
    public String getMealType() {
        return "Vegan";
    }

    public List<String> getMeals() {
        return Arrays.asList("Tofu Stir Fry", "Quinoa Bowl", "Fruit Smoothie");
    }
}

package com.introduction.personalizedmealplangenerator;

import java.util.Arrays;
import java.util.List;

class HighProteinMeal implements MealPlan {
    public String getMealType() {
        return "High-Protein";
    }

    public List<String> getMeals() {
        return Arrays.asList("Protein Shake", "Egg White Omelette", "Lentil Soup");
    }
}

class KetoMeal implements MealPlan {
    public String getMealType() {
        return "Keto";
    }

    public List<String> getMeals() {
        return Arrays.asList("Grilled Chicken", "Avocado Salad", "Boiled Eggs");
    }
}

class VegetarianMeal implements MealPlan {
    public String getMealType() {
        return "Vegetarian";
    }

    public List<String> getMeals() {
        return Arrays.asList("Paneer Tikka", "Dal Rice", "Veg Salad");
    }
}

class VeganMeal implements MealPlan {
    public String getMealType() {
        return "Vegan";
    }

    public List<String> getMeals() {
        return Arrays.asList("Tofu Stir Fry", "Quinoa Bowl", "Fruit Smoothie");
    }
}

public class Main {
    public static void main(String[] args) {
        // Create instances of each meal type
        // and generate meal plans for each type
        VegetarianMeal veg = new VegetarianMeal();
        VeganMeal vegan = new VeganMeal();
        KetoMeal keto = new KetoMeal();
        HighProteinMeal highProtein = new HighProteinMeal();

        Meal<VegetarianMeal> vegPlan = MealPlanner.generateMealPlan(veg);
        Meal<VeganMeal> veganPlan = MealPlanner.generateMealPlan(vegan);
        Meal<KetoMeal> ketoPlan = MealPlanner.generateMealPlan(keto);
        Meal<HighProteinMeal> proteinPlan = MealPlanner.generateMealPlan(highProtein);

        // Display the generated meal plans
        System.out.println();
        vegPlan.displayPlan();
        System.out.println();
        veganPlan.displayPlan();
        System.out.println();
        ketoPlan.displayPlan();
        System.out.println();
        proteinPlan.displayPlan();
    }
}