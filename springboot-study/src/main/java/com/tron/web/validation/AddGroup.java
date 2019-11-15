package com.tron.web.validation;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

/**
 * @Description
 * @auther tron
 * @create 2019-10-23
 */
@GroupSequence({Add.class,Default.class})
public interface AddGroup {
}
