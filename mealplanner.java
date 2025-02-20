import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
public class MealPlanner {
private JFrame frame;
private JPanel loginPanel;
private JPanel registerPanel;
private JPanel mainPanel;
private JTextField loginUsernameField;
private JPasswordField loginPasswordField;
private JTextField registerUsernameField;
private JPasswordField registerPasswordField;
private JTextField registerEmailField;
private JTextField registerHeightField;
private JTextField registerWeightField;
private List<User> users;
private User currentUser;
private List<Recipe> recipes;
public MealPlanner() {
users = new ArrayList<>();
recipes = new ArrayList<>();
// Adding a sample user for testing
users.add(new User("admin", "admin", "admin@example.com", 1.75, 70));
// Sample recipes with calorie information
recipes.add(new Recipe("Salad", "Healthy green salad with vegetables.", 150));
recipes.add(new Recipe("Grilled Chicken", "Grilled chicken breast with herbs.", 250));
recipes.add(new Recipe("Pasta", "Whole grain pasta with tomato sauce.", 400));
recipes.add(new Recipe("Fruit Smoothie", "Mixed fruit smoothie with yogurt.", 200));
recipes.add(new Recipe("Quinoa Bowl", "Quinoa with vegetables and beans.", 350));
initialize();}
private void initialize() {
frame = new JFrame("Meal Planner App");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(400, 300);
frame.getContentPane().setBackground(Color.LIGHT_GRAY); // Background color
showLoginPanel();
frame.setVisible(true);}
private void showLoginPanel() {
loginPanel = new JPanel();
loginPanel.setLayout(new GridLayout(4, 2));
loginPanel.setBackground(Color.WHITE); // Panel background color
JLabel usernameLabel = new JLabel("Username:");
usernameLabel.setForeground(Color.BLUE); // Label color
loginUsernameField = new JTextField();
JLabel passwordLabel = new JLabel("Password:");
passwordLabel.setForeground(Color.BLUE); // Label color
loginPasswordField = new JPasswordField();
JButton loginButton = new JButton("Login");
loginButton.setBackground(Color.GREEN); // Button color
loginButton.setForeground(Color.WHITE); // Button text color
JButton switchToRegisterButton = new JButton("Register");
switchToRegisterButton.setBackground(Color.ORANGE); // Button color
switchToRegisterButton.setForeground(Color.WHITE); // Button text color
loginButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
handleLogin();}};
switchToRegisterButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
showRegisterPanel();}});
loginPanel.add(usernameLabel);
loginPanel.add(loginUsernameField);
loginPanel.add(passwordLabel);
loginPanel.add(loginPasswordField);
loginPanel.add(loginButton);
loginPanel.add(switchToRegisterButton);
frame.getContentPane().removeAll();
frame.getContentPane().add(loginPanel);
frame.validate();
frame.repaint();}
private void showRegisterPanel() {
registerPanel = new JPanel();
registerPanel.setLayout(new GridLayout(6, 2));
registerPanel.setBackground(Color.WHITE); // Panel background color
JLabel usernameLabel = new JLabel("Username:");
usernameLabel.setForeground(Color.BLUE); // Label color
registerUsernameField = new JTextField();
JLabel passwordLabel = new JLabel("Password:");
passwordLabel.setForeground(Color.BLUE); // Label color
registerPasswordField = new JPasswordField();
JLabel emailLabel = new JLabel("Email:");
emailLabel.setForeground(Color.BLUE); // Label color
registerEmailField = new JTextField();
JLabel heightLabel = new JLabel("Height (m):");
heightLabel.setForeground(Color.BLUE); // Label color
registerHeightField = new JTextField();
JLabel weightLabel = new JLabel("Weight (kg):");
weightLabel.setForeground(Color.BLUE); // Label color
registerWeightField = new JTextField();
JButton registerButton = new JButton("Register");
registerButton.setBackground(Color.GREEN); // Button color
registerButton.setForeground(Color.WHITE); // Button text color
JButton switchToLoginButton = new JButton("Back to Login");
switchToLoginButton.setBackground(Color.ORANGE); // Button color
switchToLoginButton.setForeground(Color.WHITE); // Button text color
registerButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
handleRegister();}});
switchToLoginButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
showLoginPanel();}});
registerPanel.add(usernameLabel);
registerPanel.add(registerUsernameField);
registerPanel.add(passwordLabel);
registerPanel.add(registerPasswordField);
registerPanel.add(emailLabel);
registerPanel.add(registerEmailField);
registerPanel.add(heightLabel);
registerPanel.add(registerHeightField);
registerPanel.add(weightLabel);
registerPanel.add(registerWeightField);
registerPanel.add(registerButton);
registerPanel.add(switchToLoginButton);
frame.getContentPane().removeAll();
frame.getContentPane().add(registerPanel);
frame.validate();
frame.repaint();}
private void showMainPanel() {
mainPanel = new JPanel();
mainPanel.setLayout(new GridLayout(7, 1));
mainPanel.setBackground(Color.WHITE); // Panel background color
JLabel bmiLabel = new JLabel("Your BMI: " + String.format("%.2f", currentUser.calculateBMI()));
bmiLabel.setForeground(Color.BLUE);
mainPanel.add(bmiLabel);
JButton addRecipeButton = new JButton("Add Recipe");
addRecipeButton.setBackground(Color.GREEN); // Button color
addRecipeButton.setForeground(Color.WHITE); // Button text color
JButton listRecipesButton = new JButton("List Recipes");
listRecipesButton.setBackground(Color.GREEN); // Button color
listRecipesButton.setForeground(Color.WHITE); // Button text color
JButton createMealPlanButton = new JButton("Create Meal Plan");
createMealPlanButton.setBackground(Color.GREEN); // Button color
createMealPlanButton.setForeground(Color.WHITE); // Button text color
JButton suggestMealPlanButton = new JButton("Suggest Meal Plan Based on BMI");
suggestMealPlanButton.setBackground(Color.GREEN); // Button color
suggestMealPlanButton.setForeground(Color.WHITE); // Button text color
JButton logoutButton = new JButton("Logout");
logoutButton.setBackground(Color.RED); // Button color
logoutButton.setForeground(Color.WHITE); // Button text color
addRecipeButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
showAddRecipeDialog();}});
listRecipesButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
showListRecipesDialog();}});
createMealPlanButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
showCreateMealPlanDialog();}});
suggestMealPlanButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
suggestMealPlan(currentUser.calculateBMI());
}});
logoutButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
currentUser = null;
showLoginPanel();}});
mainPanel.add(addRecipeButton);
mainPanel.add(listRecipesButton);
mainPanel.add(createMealPlanButton);
mainPanel.add(suggestMealPlanButton);
mainPanel.add(logoutButton);
frame.getContentPane().removeAll();
frame.getContentPane().add(mainPanel);
frame.validate();
frame.repaint();}
private void handleLogin() {
String username = loginUsernameField.getText();
String password = new String(loginPasswordField.getPassword());
for (User user : users) {
if (user.getUsername().equals(username) && user.checkPassword(password)) {
currentUser = user;
showMainPanel();
return;}}
JOptionPane.showMessageDialog(frame, "Invalid username or password.", "LoginFailed", JOptionPane.ERROR_MESSAGE);}
private void handleRegister() {
String username = registerUsernameField.getText();
String password = new String(registerPasswordField.getPassword());
String email = registerEmailField.getText();
double height;
double weight;
try {
height = Double.parseDouble(registerHeightField.getText());
weight = Double.parseDouble(registerWeightField.getText());
} catch (NumberFormatException e) {
JOptionPane.showMessageDialog(frame, "Invalid height or weight.", "RegistrationFailed", JOptionPane.ERROR_MESSAGE);
return;}
for (User user : users) {
if (user.getUsername().equals(username)) {
JOptionPane.showMessageDialog(frame, "Username already exists.", "RegistrationFailed", JOptionPane.ERROR_MESSAGE);
return;}}
User newUser = new User(username, password, email, height, weight);
users.add(newUser);
JOptionPane.showMessageDialog(frame, "Registration successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
showLoginPanel();}
private void showAddRecipeDialog() {
JTextField titleField = new JTextField();
JTextField descriptionField = new JTextField();
JTextField caloriesField = new JTextField();
Object[] message = { "Recipe Title:", titleField
"Recipe Description:", descriptionField, "Calories:", caloriesField};
int option = JOptionPane.showConfirmDialog(frame, message, "Add Recipe", JOptionPane.OK_CANCEL_OPTION);
if (option == JOptionPane.OK_OPTION) {
String title = titleField.getText();
String description = descriptionField.getText();
int calories;
try {
calories = Integer.parseInt(caloriesField.getText());
} catch (NumberFormatException e) {
JOptionPane.showMessageDialog(frame, "Invalid calories.", "Error", JOptionPane.ERROR_MESSAGE);
return;}
Recipe recipe = new Recipe(title, description, calories);
recipes.add(recipe);
JOptionPane.showMessageDialog(frame, "Recipe added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);}}
private void showListRecipesDialog() {
StringBuilder recipeList = new StringBuilder();
for (Recipe r : recipes) {
recipeList.append(r.getTitle()).append(": ").append(r.getDescription()).append("(Calories:").append(r.getCalories()).append(")\n");}
JOptionPane.showMessageDialog(frame, recipeList.toString(), "Recipes", JOptionPane.INFORMATION_MESSAGE);}
private void showCreateMealPlanDialog() {
MealPlan mealPlan = new MealPlan();
while (true) {
String recipeTitle = JOptionPane.showInputDialog(frame, "Enter Recipe Title (or type'done' to finish):", "Create Meal Plan", JOptionPane.PLAIN_MESSAGE);
if (recipeTitle == null || recipeTitle.equalsIgnoreCase("done")) {
break;
}
boolean found = false;
for (Recipe r : recipes) {
if (r.getTitle().equalsIgnoreCase(recipeTitle)) {
mealPlan.addRecipe(r);
JOptionPane.showMessageDialog(frame, "Added to Meal Plan: " + r.getTitle(), "Success", JOptionPane.INFORMATION_MESSAGE);
found = true;
break;
}
}
if (!found) {
JOptionPane.showMessageDialog(frame, "Recipe not found.", "Error", JOptionPane.ERROR_MESSAGE);
}
}
StringBuilder mealPlanSummary = new StringBuilder();
mealPlanSummary.append("Meal Plan created successfully withthefollowing recipes:\n");
for (Recipe r : mealPlan.getRecipes()) {
mealPlanSummary.append(r.getTitle()).append(": ").append(r.getDescription()).append("(Calories: ").append(r.getCalories()).append(")\n");
JOptionPane.showMessageDialog(frame, mealPlanSummary.toString(), "Meal Plan", JOptionPane.INFORMATION_MESSAGE);
}
private void suggestMealPlan(double bmi) {
String suggestion;
if (bmi < 18.5) {
suggestion = "Suggested Meal Plan: High-calorie foods like nuts, avocados, and smoothies.";} else if (bmi >= 18.5 && bmi < 24.9) {
suggestion = "Suggested Meal Plan: Balanced meals with proteins, carbs, and fats.";
} else if (bmi >= 25 && bmi < 29.9) {
suggestion = "Suggested Meal Plan: Focus on lean proteins and vegetables.";
} else {
suggestion = "Suggested Meal Plan: Low-calorie meals with lots of vegetables andleanmeats.";
}
JOptionPane.showMessageDialog(frame, "User: " + currentUser.getUsername() +", BMI:" + bmi + "\n" + suggestion, "Suggested Meal Plan", JOptionPane.INFORMATION_MESSAGE);
}
public static void main(String[] args) {
SwingUtilities.invokeLater(() -> new MealPlanner());
}
}
class User {
private String username;
private String password;
private String email;
private double height; // in meters
private double weight; // in kg
public User(String username, String password, String email, double height, double weight){this.username = username;
this.password = password;
this.email = email;
this.height = height;
this.weight = weight;
}
public String getUsername() {
return username;
}
public boolean checkPassword(String password) {
return this.password.equals(password);
}
public double calculateBMI() {
return weight / (height * height);
}
}
class Recipe {
private String title;
private String description;
private int calories;
public Recipe(String title, String description, int calories) {
this.title = title;
this.description = description;
this.calories = calories;
}
public String getTitle() {
return title;
}
public String getDescription() {
return description;
}
public int getCalories() {
return calories;
}
}
class MealPlan {
private List<Recipe> recipes;
public MealPlan() {
recipes = new ArrayList<>();
}
public void addRecipe(Recipe recipe) {
recipes.add(recipe);
}
public List<Recipe> getRecipes() {
return recipes;
}
}
