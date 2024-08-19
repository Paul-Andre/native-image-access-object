#include <stdio.h>
#include <stdlib.h>

#include "libpoint.h"

int main(void) {
  graal_isolate_t *isolate = NULL;
  graal_isolatethread_t *thread = NULL;
  if (graal_create_isolate(NULL, &isolate, &thread) != 0) {
    fprintf(stderr, "initialization error\n");
    return 1;
  }

  void * point = Point_create(thread, 10, 11);
  printf("%i\n", Point_getX(thread, point));
  Point_setX(thread, point, 20);
  printf("%i\n", Point_getX(thread, point));
  Point_destroy(thread, point);

  graal_tear_down_isolate(thread);
}
