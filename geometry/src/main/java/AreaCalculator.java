class AreaCalculator {
  public static void printArea(Shape shape){
    System.out.println(shape.area());
  }
  public static void printPerimeter(Rectangle shape){
    System.out.println(shape.perimeter());
  }
  public static void main(String[] args) {
    printArea(new Rectangle(2,4));
    printArea(new Square(2));
    printPerimeter(new Square(2));
    printPerimeter(new Rectangle(2,4));
  }
}
