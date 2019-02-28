LinkedList Java-Education-Project
===

## Features

### Unsorted List

* add objects at the end of the list
* insert objects at specific index of the list
* get objects at specific index of the list
* delete objects at specific index of the list

### Sorted List

* add objects to the sorted list; the new object will be automatic inserted at the right position thought the sort-algorithm
* get objects at specific index of the list
* delete objects at specific index of the list

## Usage

### create new LinkedList
```java
LinkedList <name> = new LinkedList(boolean sorted, IntCompare compare);
```

> The parameters are optional for the sorted list. The default LinkedList (without parameters) is unsorted.
>
> The interface 'IntCompare'/'compare' defines a custom compare function for the sorting of the list.
> This sort function must be defined for the sorted list.

### add list object
```java
add(Object object)
```

### insert list object
```java
insert(Object object, int position)
```

### get list object
```java
get(int index)
```

### delete list object
```java
delete(int index)
```

***
**An example of implementation with sorting in the 'ListExample.java' file!**
