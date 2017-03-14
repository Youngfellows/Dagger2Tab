package com.ssdj.dagger2tab.dagger;

import com.ssdj.dagger2tab.MainActivity;

import dagger.Component;

/**
 * @author 陈  杰
 * @version $Rev$
 * @time 2017/2/20 16:54
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */
@Component(modules = {AppModule.class})
public interface AppComponent
{
    void inject(MainActivity activity);
}
