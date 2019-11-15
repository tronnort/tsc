package com.tron.web.validation;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

/**
 * @Description
 * @auther tron
 * @create 2019-10-23
 */
@GroupSequence({Update.class,Default.class})
public interface UpdateGroup {
}
