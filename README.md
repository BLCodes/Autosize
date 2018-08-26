# Autosize
针对Android屏幕适配所整合的几种常用方案
## 宽高限定符适配
设定一个基准的分辨率，其他分辨率都根据这个基准分辨率来计算，然后穷举市面上所有的Android手机的宽高像素值，在不同的尺寸文件夹内部，根据该尺寸编写对应的dimens文件</br>
![](https://github.com/tangxianqiang/Autosize/blob/master/imgs/limit.png)<br/>
缺点：增大apk包体积；系统严格匹配手机分辨率，找不到资源文件后将以默认的values文件下的尺寸大小进行适配；
## SmallestWidth适配（屏幕可用高度和宽度的最小尺寸）
与宽高限定符适配类似，只是系统在匹配尺寸资源时是按照向下最近查找的原则进行的，这样使误差更小</br>
![](https://github.com/tangxianqiang/Autosize/blob/master/imgs/smallest.png)<br/>
## 修改density
这个是目前代价最小的适配方式，系统在设置大小的时候都是使用的px，而px=dp/density，因此只需要根据不同手机的dpi设置精确的density实现适配
## 效果图（红色代表宽高限定符，蓝色代表smallestWidth）
720x1280(4.7inch)</br>
![](https://github.com/tangxianqiang/Autosize/blob/master/imgs/720x1280_4.7c.png)<br/>
768x1280(4.7inch,768的分辨率没有相应的资源文件，导致只能用默认的尺寸适配)</br>
![](https://github.com/tangxianqiang/Autosize/blob/master/imgs/768x1280_4.7c.png)<br/>
1080x1920(5.0inch)</br>
![](https://github.com/tangxianqiang/Autosize/blob/master/imgs/1080x1920_5.0c.png)<br/>
1440x2560(6.0inch)</br>
![](https://github.com/tangxianqiang/Autosize/blob/master/imgs/1440x2560_6.0c.png)<br/>
 


