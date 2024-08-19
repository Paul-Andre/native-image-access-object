import org.graalvm.nativeimage.c.function.CEntryPoint;
import org.graalvm.nativeimage.IsolateThread;
import org.graalvm.nativeimage.ObjectHandle;
import org.graalvm.nativeimage.ObjectHandles;

public final class Point {
  int x;
  int y;

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @CEntryPoint(name = "Point_create")
  public static ObjectHandle create(IsolateThread thread, int x, int y) {
    Point p = new Point(x,y);
    return ObjectHandles.getGlobal().create(p);
  }

  @CEntryPoint(name = "Point_setX")
  public static void getX(IsolateThread thread, ObjectHandle handle, int x) {
    ((Point)(ObjectHandles.getGlobal().get(handle))).x = x;
  }

  @CEntryPoint(name = "Point_getX")
  public static int getX(IsolateThread thread, ObjectHandle handle) {
    return ((Point)(ObjectHandles.getGlobal().get(handle))).x;
  }

  @CEntryPoint(name = "Point_destroy")
  public static void destroy(IsolateThread thread, ObjectHandle handle) {
    ObjectHandles.getGlobal().destroy(handle);
  }
}
