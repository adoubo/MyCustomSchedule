# MyCustomSchedule

自定义时间计划表的view


changelog:  
可以根据初始数据，将时间初始化到定义的视图上去；点击对应的位置，可以确定行与列

![确定行与列](https://github.com/adoubo/MyCustomSchedule/blob/master/Screenshot_1489741197.png)

changelog:  
根据点击位置，判断当前位置是否已经设置了时间，如果设置了，则弹出的dialog显示设置的时间，如果没有，则显示当前位置对应的小时段

![当前位置是否已经设置了时间段](https://github.com/adoubo/MyCustomSchedule/blob/master/Screenshot_1489807277.png)

changelog:  
重新自定义DayLayout为NewDayLayout，通过onTouch方法，根据所点击的坐标来确定点击的时段

changelog:  
对于标题栏的24小时进行重定义，使之与下面的时间区域位置对应。

![自定义的24小时标题栏](https://github.com/adoubo/MyCustomSchedule/blob/master/Screenshot_1490010913.png)

changelog:  
修改MyNewLayoutTitle的定义方式，在 onFinishInflate函数中添加view，让整个View走正常的measure流程，这样它能计算出所有的view的大小和父布局的高度；纠正NewDayLayout的定义，确定布局的位置是left+getWidth()

![现实上增加了左侧的文字说明](https://github.com/adoubo/MyCustomSchedule/blob/master/Screenshot_1490084597.png)
