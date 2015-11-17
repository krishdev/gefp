
    create table ChkPtDetails (
        cid int4 not null,
        CName varchar(255),
        cdlt boolean not null,
        chkmark boolean,
        filepath varchar(255),
        typeoffile varchar(255),
        primary key (cid)
    );

    create table CombinationTable (
        Comid int4 not null,
        chker boolean not null,
        cid int4,
        flpd_id int4,
        rid int4,
        Sid int4,
        primary key (Comid)
    );

    create table Departmentdetails (
        deptid int4 not null,
        DepartmentName varchar(255),
        id int4,
        primary key (deptid)
    );

    create table FlightPlanDetails (
        id int4 not null,
        ennabled boolean not null,
        name varchar(255),
        primary key (id)
    );

    create table RunwayDetails (
        rid int4 not null,
        RName varchar(255),
        rdlt boolean not null,
        primary key (rid)
    );

    create table StageDetails (
        Sid int4 not null,
        SName varchar(255),
        sdlt boolean not null,
        primary key (Sid)
    );

    create table Users (
        id int4 not null,
        cin varchar(255),
        city varchar(255),
        email varchar(255),
        enabled boolean not null,
        name varchar(255),
        password varchar(255),
        phno int8,
        username varchar(255),
        major_deptid int4,
        plan_id int4,
        primary key (id)
    );

    create table authorities (
        user_id int4 not null,
        role varchar(255)
    );

    create table departmentdetails_flightplandetails (
        plans_id int4 not null,
        deptdetails_deptid int4 not null
    );

    create table fprunway (
        fpid int4 not null,
        runwayid int4 not null,
        orderIndex int4 not null,
        primary key (fpid, orderIndex)
    );

    create table fpstage (
        fpid int4 not null,
        stageid int4 not null,
        orderIndex int4 not null,
        primary key (fpid, orderIndex)
    );

    create table user_chkpt (
        userid int4 not null,
        chkptid int4 not null
    );

    alter table CombinationTable 
        add constraint FK_46ivpv8mfpjwt1mjqlkex5v4n 
        foreign key (cid) 
        references ChkPtDetails;

    alter table CombinationTable 
        add constraint FK_reeyjvokpuotfegs8hyiaqfm5 
        foreign key (flpd_id) 
        references FlightPlanDetails;

    alter table CombinationTable 
        add constraint FK_q4cko6i1cjrnqwj5g3owghaay 
        foreign key (rid) 
        references RunwayDetails;

    alter table CombinationTable 
        add constraint FK_9sm8qffm2edcfpdvmx2iphqm5 
        foreign key (Sid) 
        references StageDetails;

    alter table Departmentdetails 
        add constraint FK_3spv7q3cmmpl36ew70y0k0p44 
        foreign key (id) 
        references FlightPlanDetails;

    alter table Users 
        add constraint FK_hnqu9mlwl3xtmrx30miy8efb8 
        foreign key (major_deptid) 
        references Departmentdetails;

    alter table Users 
        add constraint FK_tepjub63jf9ay1mot9lq4m1fh 
        foreign key (plan_id) 
        references FlightPlanDetails;

    alter table authorities 
        add constraint FK_s21btj9mlob1djhm3amivbe5e 
        foreign key (user_id) 
        references Users;

    alter table departmentdetails_flightplandetails 
        add constraint FK_6rfdy4axhpe00simpt2q7u33g 
        foreign key (deptdetails_deptid) 
        references Departmentdetails;

    alter table departmentdetails_flightplandetails 
        add constraint FK_65kcd6ehwhqp2d59x5vdp56c5 
        foreign key (plans_id) 
        references FlightPlanDetails;

    alter table fprunway 
        add constraint FK_m6ibko0bu808sjnauvtq9ht8c 
        foreign key (runwayid) 
        references RunwayDetails;

    alter table fprunway 
        add constraint FK_khxqvm8vwqgpo5e6010ybgf7w 
        foreign key (fpid) 
        references FlightPlanDetails;

    alter table fpstage 
        add constraint FK_gryesa806kw989j843ffvl6ns 
        foreign key (stageid) 
        references StageDetails;

    alter table fpstage 
        add constraint FK_hxowccu6q98s58ay0h9rp9q0f 
        foreign key (fpid) 
        references FlightPlanDetails;

    alter table user_chkpt 
        add constraint FK_qwn7y4308a46igkv45mmxt5c5 
        foreign key (chkptid) 
        references ChkPtDetails;

    alter table user_chkpt 
        add constraint FK_h72r7r2ekt7f6vmsvn8kykm73 
        foreign key (userid) 
        references Users;

    create sequence hibernate_sequence;
