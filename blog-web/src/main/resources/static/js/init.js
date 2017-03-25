var params = {
    "basedir": "",
    "model": "TicketRule"
};
var condition_and_options =
    [{
        "key": "",
        "value": "--请选择筛选条件--"
    }, {
        "key": "status",
        "value": "工单：状态"
    }, {
        "key": "type",
        "value": "工单：类型"
    }, {
        "key": "priority",
        "value": "工单：优先级"
    }, {
        "key": "group_id",
        "value": "工单：受理客服组"
    }, {
        "key": "requester_id",
        "value": "工单：发起人"
    }, {
        "key": "assignee_id",
        "value": "工单：受理客服"
    }, {
        "key": "source",
        "value": "工单：提交来源"
    }, {
        "key": "recipient",
        "value": "工单：收件邮箱"
    }, {
        "key": "tags",
        "value": "工单：标签"
    }, {
        "key": "pushed_times",
        "value": "工单：催单次数"
    }, {
        "key": "assignedAt",
        "value": "时间：打开后的小时数"
    }, {
        "key": "resolvedAt",
        "value": "时间：工单已解决后的小时数"
    }, {
        "key": "closed",
        "value": "时间：工单已关闭后的小时数"
    }, {
        "key": "organization",
        "value": "发起人：公司组织"
    }];
var condition_and_target =
{
    "status": {
        "operator": [{
            "key": "is",
            "value": "是"
        }, {
            "key": "is_not",
            "value": "不是"
        }, {
            "key": "less_than",
            "value": "小于"
        }, {
            "key": "greater_than",
            "value": "大于"
        }],
        "values": [{
            "key": "NEW",
            "value": "尚未受理"
        }, {
            "key": "OPEN",
            "value": "受理中"
        }, {
            "key": "PENDING",
            "value": "等待回复"
        }, {
            "key": "SOLVED",
            "value": "已解决"
        }, {
            "key": "CLOSED",
            "value": "已关闭"
        }],
        "type": "dropdownlist",
        "htmlOptions": []
    },
    "type": {
        "operator": [{
            "key": "is",
            "value": "是"
        }, {
            "key": "is_not",
            "value": "不是"
        }],
        "values": [{
            "key": "",
            "value": "-"
        }, {
            "key": "QUESTION",
            "value": "问题"
        }, {
            "key": "INCIDENT",
            "value": "事务"
        }, {
            "key": "PROBLEM",
            "value": "故障"
        }, {
            "key": "TASK",
            "value": "任务"
        }],
        "type": "dropdownlist",
        "htmlOptions": []
    },
    "priority": {
        "operator": [{
            "key": "is",
            "value": "是"
        }, {
            "key": "is_not",
            "value": "不是"
        }, {
            "key": "less_than",
            "value": "小于"
        }, {
            "key": "greater_than",
            "value": "大于"
        }],
        "values": [{
            "key": "",
            "value": "-"
        }, {
            "key": "LOW",
            "value": "低"
        }, {
            "key": "MEDIUM",
            "value": "中"
        }, {
            "key": "HIGH",
            "value": "高"
        }, {
            "key": "URGENT",
            "value": "紧急"
        }],
        "type": "dropdownlist",
        "htmlOptions": []
    },
    "group_id": {
        "operator": [{
            "key": "is",
            "value": "是"
        }, {
            "key": "is_not",
            "value": "不是"
        }],
        "values": [],
        "type": "dropdownlist",
        "htmlOptions": []
    },
    "requester_id": {
        "operator": [{
            "key": "is",
            "value": "是"
        }, {
            "key": "is_not",
            "value": "不是"
        }],
        "values": [],
        "type": "dropdownlist",
        "htmlOptions": []
    },
    "assignee_id": {
        "operator": [{
            "key": "is",
            "value": "是"
        }, {
            "key": "is_not",
            "value": "不是"
        }],
        "values": [{
            "key": "",
            "value": "(空)"
        }, {
            "key": "(current_user)",
            "value": "(当前用户)"
        }, {
            "key": 12503969,
            "value": "wangeguo"
        }, {
            "key": 8338949,
            "value": "王先生"
        }, {
            "key": 11694495,
            "value": "王启"
        }],
        "type": "dropdownlist",
        "htmlOptions": []
    },
    "source": {
        "operator": [{
            "key": "is",
            "value": "是"
        }, {
            "key": "is_not",
            "value": "不是"
        }],
        "values": [{
            "key": "web",
            "value": "网页表单"
        }, {
            "key": "tab",
            "value": "客服组件留言"
        }, {
            "key": "chat",
            "value": "KCHAT交谈"
        }, {
            "key": "weibo",
            "value": "新浪微博"
        }, {
            "key": "api",
            "value": "API接口"
        }, {
            "key": "mobile",
            "value": "手机端"
        }, {
            "key": "email",
            "value": "邮件"
        }, {
            "key": "voicemail",
            "value": "语音留言Voicemail"
        }, {
            "key": "inbound",
            "value": "电话呼入"
        }, {
            "key": "outbound",
            "value": "电话呼出"
        }],
        "type": "dropdownlist",
        "htmlOptions": []
    },
    "recipient": {
        "operator": [{
            "key": "is",
            "value": "是"
        }],
        "values": [],
        "type": "dropdownlist",
        "htmlOptions": []
    },
    "tags": {
        "operator": [{
            "key": "contain_at_least_one",
            "value": "包含以下任意"
        }, {
            "key": "not_contain",
            "value": "不包含"
        }],
        "values": [],
        "type": "textbox",
        "htmlOptions": [{
            "key": "class",
            "value": "textbox-tags"
        }, {
            "key": "placeholder",
            "value": "多个标签请使用空格隔开"
        }]
    },
    "pushed_times": {
        "operator": [{
            "key": "is",
            "value": "是"
        }, {
            "key": "is_not",
            "value": "不是"
        }, {
            "key": "less_than",
            "value": "小于"
        }, {
            "key": "greater_than",
            "value": "大于"
        }],
        "values": [{
            "key": 0,
            "value": "0"
        }, {
            "key": 1,
            "value": "1"
        }, {
            "key": 2,
            "value": "2"
        }, {
            "key": 3,
            "value": "3"
        }, {
            "key": 4,
            "value": "4"
        }, {
            "key": 5,
            "value": "5"
        }],
        "type": "dropdownlist",
        "htmlOptions": []
    },
    "created": {
        "operator": [{
            "key": "less_than",
            "value": "小于"
        }, {
            "key": "greater_than",
            "value": "大于"
        }, {
            "key": "is",
            "value": "是"
        }],
        "values": [],
        "type": "textbox",
        "htmlOptions": []
    },
    "assignedAt": {
        "operator": [{
            "key": "less_than",
            "value": "小于"
        }, {
            "key": "greater_than",
            "value": "大于"
        }, {
            "key": "is",
            "value": "是"
        }],
        "values": [],
        "type": "textbox",
        "htmlOptions": []
    },
    "pending": {
        "operator": [{
            "key": "less_than",
            "value": "小于"
        }, {
            "key": "greater_than",
            "value": "大于"
        }, {
            "key": "is",
            "value": "是"
        }],
        "values": [],
        "type": "textbox",
        "htmlOptions": []
    },
    "resolvedAt": {
        "operator": [{
            "key": "less_than",
            "value": "小于"
        }, {
            "key": "greater_than",
            "value": "大于"
        }, {
            "key": "is",
            "value": "是"
        }],
        "values": [],
        "type": "textbox",
        "htmlOptions": []
    },
    "closedAt": {
        "operator": [{
            "key": "less_than",
            "value": "小于"
        }, {
            "key": "greater_than",
            "value": "大于"
        }, {
            "key": "is",
            "value": "是"
        }],
        "values": [],
        "type": "textbox",
        "htmlOptions": []
    },
    "updated": {
        "operator": [{
            "key": "less_than",
            "value": "小于"
        }, {
            "key": "greater_than",
            "value": "大于"
        }, {
            "key": "is",
            "value": "是"
        }],
        "values": [],
        "type": "textbox",
        "htmlOptions": []
    },
    "requester_updated": {
        "operator": [{
            "key": "less_than",
            "value": "小于"
        }, {
            "key": "greater_than",
            "value": "大于"
        }, {
            "key": "is",
            "value": "是"
        }],
        "values": [],
        "type": "textbox",
        "htmlOptions": []
    },
    "assignee_updated": {
        "operator": [{
            "key": "less_than",
            "value": "小于"
        }, {
            "key": "greater_than",
            "value": "大于"
        }, {
            "key": "is",
            "value": "是"
        }],
        "values": [],
        "type": "textbox",
        "htmlOptions": []
    },
    "before_due_date": {
        "operator": [{
            "key": "less_than",
            "value": "小于"
        }, {
            "key": "greater_than",
            "value": "大于"
        }, {
            "key": "is",
            "value": "是"
        }],
        "values": [],
        "type": "textbox",
        "htmlOptions": []
    },
    "after_due_date": {
        "operator": [{
            "key": "less_than",
            "value": "小于"
        }, {
            "key": "greater_than",
            "value": "大于"
        }, {
            "key": "is",
            "value": "是"
        }],
        "values": [],
        "type": "textbox",
        "htmlOptions": []
    },
    "organization": {
        "operator": [{
            "key": "is",
            "value": "是"
        }, {
            "key": "is_not",
            "value": "不是"
        }],
        "values": [],
        "type": "dropdownlist",
        "htmlOptions": []
    },
    "{language}": {
        "operator": [{
            "key": "is",
            "value": "是"
        }, {
            "key": "is_not",
            "value": "不是"
        }],
        "values": [{
            "key": "zh_cn",
            "value": "简体中文"
        }, {
            "key": "en",
            "value": "English"
        }],
        "type": "dropdownlist",
        "htmlOptions": []
    }
};
var condition_or_options = [{
    "key": "",
    "value": "--请选择筛选条件--"
}, {
    "key": "status",
    "value": "工单：状态"
}, {
    "key": "type",
    "value": "工单：类型"
}, {
    "key": "priority",
    "value": "工单：优先级"
}, {
    "key": "group_id",
    "value": "工单：受理客服组"
}, {
    "key": "requester_id",
    "value": "工单：发起人"
}, {
    "key": "assignee_id",
    "value": "工单：受理客服"
}, {
    "key": "source",
    "value": "工单：提交来源"
}, {
    "key": "recipient",
    "value": "工单：收件邮箱"
}, {
    "key": "tags",
    "value": "工单：标签"
}, {
    "key": "organization",
    "value": "发起人：公司组织"
}];
var condition_or_target = {
    "status": {
        "operator": [{
            "key": "is",
            "value": "是"
        }, {
            "key": "is_not",
            "value": "不是"
        }, {
            "key": "less_than",
            "value": "小于"
        }, {
            "key": "greater_than",
            "value": "大于"
        }],
        "values": [{
            "key": "NEW",
            "value": "尚未受理"
        }, {
            "key": "OPEN",
            "value": "受理中"
        }, {
            "key": "PENDING",
            "value": "等待回复"
        }, {
            "key": "SOLVED",
            "value": "已解决"
        }, {
            "key": "CLOSED",
            "value": "已关闭"
        }],
        "type": "dropdownlist",
        "htmlOptions": []
    },
    "type": {
        "operator": [{
            "key": "is",
            "value": "是"
        }, {
            "key": "is_not",
            "value": "不是"
        }],
        "values": [{
            "key": "",
            "value": "-"
        }, {
            "key": "QUESTION",
            "value": "问题"
        }, {
            "key": "INCIDENT",
            "value": "事务"
        }, {
            "key": "PROBLEM",
            "value": "故障"
        }, {
            "key": "TASK",
            "value": "任务"
        }],
        "type": "dropdownlist",
        "htmlOptions": []
    },
    "priority": {
        "operator": [{
            "key": "is",
            "value": "是"
        }, {
            "key": "is_not",
            "value": "不是"
        }, {
            "key": "less_than",
            "value": "小于"
        }, {
            "key": "greater_than",
            "value": "大于"
        }],
        "values": [{
            "key": "",
            "value": "-"
        }, {
            "key": "LOW",
            "value": "低"
        }, {
            "key": "MEDIUM",
            "value": "中"
        }, {
            "key": "HIGH",
            "value": "高"
        }, {
            "key": 3,
            "value": "紧急"
        }],
        "type": "dropdownlist",
        "htmlOptions": []
    },
    "group_id": {
        "operator": [{
            "key": "is",
            "value": "是"
        }, {
            "key": "is_not",
            "value": "不是"
        }],
        "values": [],
        "type": "dropdownlist",
        "htmlOptions": []
    },
    "requester_id": {
        "operator": [{
            "key": "is",
            "value": "是"
        }, {
            "key": "is_not",
            "value": "不是"
        }],
        "values": [],
        "type": "dropdownlist",
        "htmlOptions": []
    },
    "assignee_id": {
        "operator": [{
            "key": "is",
            "value": "是"
        }, {
            "key": "is_not",
            "value": "不是"
        }],
        "values": [],
        "type": "dropdownlist",
        "htmlOptions": []
    },
    "source": {
        "operator": [{
            "key": "is",
            "value": "是"
        }, {
            "key": "is_not",
            "value": "不是"
        }],
        "values": [{
            "key": "web",
            "value": "网页表单"
        }, {
            "key": "tab",
            "value": "客服组件留言"
        }, {
            "key": "chat",
            "value": "KCHAT交谈"
        }, {
            "key": "weibo",
            "value": "新浪微博"
        }, {
            "key": "api",
            "value": "API接口"
        }, {
            "key": "mobile",
            "value": "手机端"
        }, {
            "key": "email",
            "value": "邮件"
        }, {
            "key": "voicemail",
            "value": "语音留言Voicemail"
        }, {
            "key": "inbound",
            "value": "电话呼入"
        }, {
            "key": "outbound",
            "value": "电话呼出"
        }],
        "type": "dropdownlist",
        "htmlOptions": []
    },
    "recipient": {
        "operator": [{
            "key": "is",
            "value": "是"
        }],
        "values": [],
        "type": "dropdownlist",
        "htmlOptions": []
    },
    "tags": {
        "operator": [{
            "key": "contain_at_least_one",
            "value": "包含以下任意"
        }, {
            "key": "not_contain",
            "value": "不包含"
        }],
        "values": [],
        "type": "textbox",
        "htmlOptions": [{
            "key": "class",
            "value": "textbox-tags"
        }, {
            "key": "placeholder",
            "value": "多个标签请使用空格隔开"
        }]
    },
    "organization": {
        "operator": [{
            "key": "is",
            "value": "是"
        }, {
            "key": "is_not",
            "value": "不是"
        }],
        "values": [],
        "type": "dropdownlist",
        "htmlOptions": []
    }
};
var condition_action_options = [{
    "key": "",
    "value": "--请选择工单动作--"
}];
var condition_action_target = {};

var show_field = [{
    "key": "id",
    "value": "编号"
}, {
    "key": "title",
    "value": "标题"
}, {
    "key": "description",
    "value": "问题描述"
}, {
    "key": "status",
    "value": "状态"
}, {
    "key": "type",
    "value": "类型"
}, {
    "key": "priority",
    "value": "优先级"
}, {
    "key": "requester_id",
    "value": "工单发起人"
}, {
    "key": "group_id",
    "value": "受理客服组"
}, {
    "key": "assginee_id",
    "value": "工单受理客服"
}, {
    "key": "created_at",
    "value": "创建日期"
}, {
    "key": "organization_id",
    "value": "公司组织"
}];

var group_field = [];
